var  playerObj;
var enemyObj;
var distance;

function preload(){
    loadImages();
    loadSounds();
}

function setup(){
    createCanvas(constant.WIDTH,constant.HEIGHT);
    playerObj = new Player();
    enemyObj  = new Enemy(); 
    bgSound.loop();
}

function draw(){
    background(bg);
    playerObj.drawPlayer();
    enemyObj.drawEnemy();
    enemyObj.move();
    playerObj.fall();
    collision();
}

function keyPressed(){
    console.log(keyCode);
    if(keyCode==constant.SPACE_KEY){
        playerObj.jump();
    }
}

function collision(){
    distance = dist(playerObj.x, playerObj.y, enemyObj.x,enemyObj.y);
    if(distance<playerObj.h/2+enemyObj.h/2-35){
        textSize(50);
        text("Game Over",200,300);
        noLoop();
    
        bgSound.stop();
    }
    
}