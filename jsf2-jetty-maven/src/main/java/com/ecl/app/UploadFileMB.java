package com.ecl.app;


    import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import org.primefaces.model.UploadedFile;


    @ManagedBean
    @SessionScoped
    public class UploadFileMB {
    UploadedFile file;
    String text;

        public String getText() {
            return text;
        }

        public void setText(String text) {
            this.text = text;
        }


        public UploadedFile getFile() {
            return file;
        }

        public void setFile(UploadedFile file) {
            this.file = file;
        }

        public void submit(){


         System.out.println("Trial "+file);
         UploadedFile a=file;
         if(file==null)
             text="not uploaded";
         else
             text=file.getFileName()+" uploaded";
                 }
        /** Creates a new instance of UploadFileMB */
        public UploadFileMB() {
        }
    }