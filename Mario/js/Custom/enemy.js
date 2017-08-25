 var Enemy = function(){
    
    this.x = width;
    this.y = constant.FLOOR;
    this.h = this.w = 100;
    this.img = enemyImage;
    this.speed = -4;
     
    this.drawEnemy = function(){
        image(this.img,this.x,this.y,this.w,this.h);
    }
        
    this.move = function(){
        this.x = this.x+this.speed;
        if(this.x<=0){
            this.x = width;
        }        
    }
    
}