/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package protodo;

/**
 *
 * @author timet
 */
public class Task {
    
    private String title;
    
    private boolean isCompleted;

    
    /**
    - Constructs a new task with a specific title
    - completion status is initialized to false
    * @param title The name of the task
    **/
    public Task(String title){
        this.title = title;
        
        this.isCompleted = false;
    }
    
    // this is the getter
   public String getTitle(){
       return title;
   }
   
   //this is the setter
   public void setTitle(String title){
       this.title = title;
   }
      
   public boolean isCompleted(){
       return isCompleted;
   }
   
   public void setCompleted(boolean isCompleted){
       this.isCompleted = isCompleted;
   }
    
   @Override 
   public String toString(){
       String status = (isCompleted) ? "X":" ";
       return "[" + status + "] " + title;
   }
}
