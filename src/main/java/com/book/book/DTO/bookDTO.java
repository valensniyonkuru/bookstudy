package com.book.book.DTO;

public class bookDTO {
    private Integer Book_id;
    private String Book_name;

public bookDTO(Integer bookId,String bookName){
    this.Book_id=bookId;
    this.Book_name=bookName;
}
public bookDTO(){
}
  public Integer getBookid(){
    return Book_id;
  }
  public void setBookid(Integer bookId){
    this.Book_id=bookId;

  }
  public String getBookName(){
    return Book_name;
  }
  public void setBookNme( String newBookName){
    this.Book_name=newBookName;
  }

  @Override
    public String toString(){
    return "BookId:"+Book_id + ",BookName:"+ Book_name;
  }
}
