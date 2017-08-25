 var Player = function(){
    
    this.x = 30;
    this.y = constant.FLOOR;
    this.h = this.w = 100;
    this.img = playerImage;
    this.force = 0; 
    this.gravity = 0.5; 
    this.isPlayerJump = false;
     
    this.drawPlayer = function(){
        image(this.img,this.x,this.y,this.w,this.h);
    }
    
    this.jump = function(){
        if(!this.isPlayerJump){
        this.force = -13;
        this.y = this.y + this.force;
        this.isPlayerJump = true;    
    }
 }
    
   this.fall = function(){
       if(this.y<constant.FLOOR){
           this.force = this.force + this.gravity;
           this.y = this.y + this.force;
       }
       if(this.y>=constant.FLOOR){
           this.isPlayerJump = false;
       }
   }
}