public class Card implements Comparable<Card> {

    final int rank;//2-10 for numeric card, 11-14 for jack, queen, king, ace
    final char suit;// chars 'C','D','H','S', for clubs diamonds hearts and spades

    public Card(int r, char s){
        rank = r;
        suit = s;
    }
    @Override
    public boolean equals(Object c){
        if(this == c){
            return true;
        }
        if(!(c instanceof Card)){
            return false;
        }

        Card card = (Card) c;
        if(this.rank==card.rank && this.suit==card.suit){
            return true;
        }
        else{
            return false;
        }
    }

    @Override
    public String toString(){
        String a="";
        switch(this.suit){
            case 'C':
                a = "Clubs";
                break;
            case 'D':
                a = "Diamonds";
                break;
            case 'H':
                a = "Hearts";
                break;
            case 'S':
                a = "Spades";
                break;
        }
        if(this.rank==11){
            return "Jack of "+a;
        }
        else if(this.rank==12){
            return "Queen of "+a;
        }
        else if(this.rank==13){
            return "King of "+a;
        }
        else if(this.rank==14){
            return "Ace of "+a;
        }
        return rank+" of "+a;
    }


    @Override
    public int compareTo(Card other) {
        int suitVal=0;
        int suitValO=0;
            
        switch(this.suit){
            case 'C':
                suitVal = 0;
                break;
            case 'D':
                suitVal = 1;
                break;
            case 'H':
                suitVal = 2;
                break;
            case 'S':
                suitVal = 3;
                break;
        }

        switch(other.suit){
            case 'C':
                suitValO = 0;
                break;
            case 'D':
                suitValO = 1;
                break;
            case 'H':
                suitValO = 2;
                break;
            case 'S':
                suitValO = 3;
                break;
        }

        if(this.rank == other.rank){
            if(suitVal<suitValO){
                return -1;//same rank, other card is greater
            }
            else if(suitVal>suitValO){
                return 1;// same rank, this card is higher
            }
            else{
                return 0;//same rank and same suit
            }
        }
        else if(this.rank<other.rank){
            return -1;//this card is lower than other card
        }
        else{
            return 1;//this card is higher than other card
        }
    }  
}
