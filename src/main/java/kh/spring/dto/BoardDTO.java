package kh.spring.dto;

public class BoardDTO {
   private String seq;
   private String title;
   private String contents;
   private String writer;
   private String writedate;
   private String viewcount;
   private String ip;
   
   public BoardDTO() {
   }

   public BoardDTO(String seq, String title, String contents, String writer, String writedate, String viewcount,
         String ip) {
      this.seq = seq;
      this.title = title;
      this.contents = contents;
      this.writer = writer;
      this.writedate = writedate;
      this.viewcount = viewcount;
      this.ip = ip;
   }

   public String getSeq() {
      return seq;
   }

   public void setSeq(String seq) {
      this.seq = seq;
   }

   public String getTitle() {
      return title;
   }

   public void setTitle(String title) {
      this.title = title;
   }

   public String getContents() {
      return contents;
   }

   public void setContents(String contents) {
      this.contents = contents;
   }

   public String getWriter() {
      return writer;
   }

   public void setWriter(String writer) {
      this.writer = writer;
   }

   public String getWritedate() {
      return writedate;
   }

   public void setWritedate(String writedate) {
      this.writedate = writedate;
   }

   public String getViewcount() {
      return viewcount;
   }

   public void setViewcount(String viewcount) {
      this.viewcount = viewcount;
   }

   public String getIp() {
      return ip;
   }

   public void setIp(String ip) {
      this.ip = ip;
   }
   
   
}