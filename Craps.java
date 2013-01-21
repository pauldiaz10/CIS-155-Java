// Paul Diaz
// pauldiaz@my.smccd.edu
// CIS 254JA
// Object-Oriented Progamming
// Assignment #6
// 04/16/12
import java.util.Random;

public class Craps 
{
    //create random number generator for use in method rollDice
    private Random randomNumbers = new Random();
    
    //enumeration with constants that represent the game status
    private enum Status{CONTINUE, WON, LOST};
    
    //constants that represent common rolls of the dice
    private static final int SNAKE_EYES = 2;
    private static final int TREY = 3;
    private static final int SEVEN = 7;
    private static final int YO_LEVEN = 11;
    private static final int BOX_CARS = 12;
    
    int[] winGames;//array for winnings
    int[] lostGames;//array for losses
    int totalWin;
    int totalLose;
    int numGames = 1000;//number of games
    int index = 21;
    
    //plays one game of craps
    public void play()
    {
        int sumOfDice;//total of 2 dice
        int myPoints = 0;//point if no win or loss on first roll
        int roll;
        Status gameStatus;//can contain CONTINUE, WON or LOST

        winGames = new int[ 22 ];
        lostGames = new int[ 22 ];
        
        //for loop of 1000 games of craps
        for ( int counter = 1; counter <= numGames; counter++)
	{
            sumOfDice = rollDice();
            roll = 1;

            switch( sumOfDice )
	    {
            	case SEVEN://win with 7 on first roll
            	case YO_LEVEN://win with 11 on first roll
     	           gameStatus=Status.WON;
		   break;

                case SNAKE_EYES://lose with 2 on first roll
		case TREY://lose with 3 on first roll
		case BOX_CARS://lose with 12 on first roll
		   gameStatus=Status.LOST;
		   break;

            	default://did not win or lose, so remember point
		   gameStatus=Status.CONTINUE;//game is not over
		   myPoints = sumOfDice;//remember the point
                   break;//optional at end of switch
            }//end switch
        
        //while game is not complete
        while( gameStatus == Status.CONTINUE )// not WON or LOST
	{
            sumOfDice = rollDice();//roll dice again
            roll++;
            
            //determine game status
            if( sumOfDice == myPoints )//win by making point
                gameStatus = Status.WON;

            else if( sumOfDice == 7 )//lose by rolling 7 before point
                gameStatus=Status.LOST;
        }
        if ( roll > index )
            roll = index;
        
        if ( gameStatus == Status.WON )
	{
            ++winGames[roll];//increment each winnings
            ++totalWin;//increment total of winnings
        }
        else
        {
            ++lostGames[roll];//increment each losses
            ++totalLose;//increment total of losses
        }
      }//end for loop
   }//end play method
   //roll dice, calculate sum
   public int rollDice()
   {
        int die1=1+randomNumbers.nextInt(6);//first die roll
        int die2=1+randomNumbers.nextInt(6);//second die roll

        int sum = die1 + die2;//sum of die values

        return sum;//return sum of dice
    }//end rollDice method
    //printStatistics method to find out the number of winnings, losses,
    //chances of winnings and average game length
    public void printStatistics()
    {
        double length = 0;
        int totalGames;
        double average;

        for( int counter = 1; counter <= index; counter++)
        {
            length += winGames[ counter ] * counter + lostGames[ counter ] * counter;
            
            if( counter == index )//output for the 20th roll
                System.out.printf("\n%d games won and %d games lost on rolls after the 20th roll", 
                        winGames[index],lostGames[index] );
            else
                if( counter <= index )//output before the 20th roll
                    System.out.printf("\n%d games won and %d games lost on roll # %d", 
                            winGames[counter], lostGames[counter], counter);         
        }
        totalGames = totalWin + totalLose;//add winnings and losses 
        average = length / totalGames;//will to get the average game length
        
    	System.out.printf("\n\n%s %d / %d = %.2f%%\n", 
                "The chances of winning are", totalWin, totalGames, (100.0 * totalWin/totalGames));
        
        System.out.printf( "The average game length is %.2f rolls.\n", average);
    }
 }
