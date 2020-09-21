public class Arrow extends Piece
{
    private boolean direction;
    Arrow(int x, int y, String color)
    {
    	super(x,y,color);
    	String pieceName = "ARR";
    	super.setPieceName(pieceName);
    	if(color == "R") {
    		super.setPieceIcon("images/Red_Arrow.png");
    	} else {
    		super.setPieceIcon("images/Blue_Arrow.png");
    	}
    	
    	if (color == "R")//top piece
    	{
    	    this.direction = false; // facing to South (down)
    	}
    	else if (color == "B")//bottom piece
    	{
    	    this.direction = true; //facing to North (up)
    	}
    	
    	movementType = new MovementArrow();
    }
    
    public boolean getDirection() {
    	return direction;
    }
    
    public void checkChangeDirection() {
    	if (direction && super.getCurrentY() == 7){
    		direction = false;
    	} else if (!direction && super.getCurrentY() == 0) {
    		direction = true;
    	}
    }
    
    public boolean isValidMove(GameBoard board, GameBoardSpot start, GameBoardSpot end)//the input from click mouse position
    {
    	if (end.getPiece() != null) {
	        if (super.getColor() == end.getPiece().getColor())//check if the clicked mouse position is an ally or not, if ally then return false else proceed to do checking for obstacles
	        {
	            return false;//if the end spot is ally then return false
	        }
    	}
        
    	//Check need to change direction or not
    	checkChangeDirection();
    	
    	return movementType.checkValidMove(board, start, end, direction);
    }
}