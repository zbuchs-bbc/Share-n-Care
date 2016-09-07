package ch.bbcag.shareandcare.web.controller;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;

import model.User;
import ch.bbcag.shareandcare.profil.ImageUploadBeanLocal;

@ManagedBean
@RequestScoped
public class ImageUploadController {
	private static final String PFAD = "C:/glassfish4/glassfish4/glassfish/domains/domain1/docroot/ressources/images/";
	private static final String PFAD2 = "/ressources/images/";

	private String username;
	private String image;
	private Part file;
	public File webPath;

	@EJB
	private ImageUploadBeanLocal imageUploadBeanLocal;

	public String uploadImage() {

		InputStream inputStream = null;
		FileOutputStream outputStream = null;

		try {
			String picture = file.getSubmittedFileName();
			File path = new File(PFAD + picture);
			outputStream = new FileOutputStream(path);
			if (!path.exists()) {
				path.createNewFile();
			}
			int read = 0;
			byte[] bytes = new byte[1024];

			inputStream = file.getInputStream();
			while ((read = inputStream.read(bytes)) != -1) {
				outputStream.write(bytes, 0, read);
			}

			// System.out.println(path.toString());

			webPath = new File(PFAD2 + picture);

			HttpSession s = (HttpSession) FacesContext.getCurrentInstance()
					.getExternalContext().getSession(false);
			User u = (User) s.getAttribute("user");
			if (u != null && u.getUsername() != null
					&& !u.getUsername().isEmpty()) {
				imageUploadBeanLocal.uploadImage(u.getUsername(), PFAD2
						+ picture);
			}

			System.out.println(webPath.toString());

		} catch (IOException e) {
			// Error handling
		} finally {
			if (inputStream != null) {
				try {
					inputStream.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			if (outputStream != null) {
				try {
					outputStream.flush();
					outputStream.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		return "login.xhtml";
	}

	public Part getFile() {
		return file;
	}

	public void setFile(Part file) {
		this.file = file;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

}
