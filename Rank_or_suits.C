#include <stdio.h>
#include <string.h>
#include <ctype.h>
#include <time.h>
#include <stdlib.h>
#include <unistd.h>

#define FALSE 0
#define TRUE 1

enum Suit { Clubs, Diamonds, Hearts, Spades };
enum Rank { Two, Three, Four, Five, Six, Seven, Eight, Nine, Ten, Jack, Queen, King, Ace };

char* SuitNames[] = { "Clubs", "Diamonds", "Hearts", "Spades" };
char* RankNames[] = { "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine", "Ten", "Jack", "Queen", "King", "Ace" };

typedef struct CardStructure
{
	enum Suit suit;
	enum Rank rank;
} Card;

void rules(int);
void playMove(Card* playerHand[], Card* compHand[]);
void dealCards(Card* playerHand[], Card* compHand[], Card* deck[]);
int compareCards(Card* playerCard, Card* compCard);
int checkWin(Card* playerHand[], Card* compHand[]);
void PlayPlayer(Card* playerHand[], Card* player2Hand[], char name1[20], char name2[20]);
int print(int, int);
int printcmpvsplayer(int, int), j;
int checkGuess(Card* playerCard, Card* compCard, int);
int checkPlayerWin(Card* playerHand[], Card* player2Hand[], char name1[20], char name2[20]);
char name1[20], name2[20], name[20], ab[9] = { '\0','P','E','N','A','L','T','Y' };;
static int lfor1, lfor2, m, l, i, a;

int main()//main
{
	Card* playerHand[52];
	Card* compHand[52];
	Card* player2Hand[52];
	Card* deck[52];
	char playAgain, input;
	int select;
	printf("WELCOME TO THE GAME OF SUITS AND RANKS!!!\n");
	printf("Guess here and you will know if you are lucky or not!\n\n");
	printf("Please select a mode to play the game.\n");
	printf("\t1)Computer VS player\n\t2)Player VS Player\n");
	scanf("%d", &select);
	switch (select)
	{
	case 1:
		rules(select);
		printf("Tell us about yourself:\n Name:");
		scanf("%s", name);
		sleep(2);
		do
		{
			dealCards(playerHand, compHand, deck);
			int moves = 1;
			while (1)
			{
				printf("\n\nMove: %d\n", moves);
				playMove(playerHand, compHand);
				int result = checkWin(playerHand, compHand);
				if (m == 7)
					result = 2;
				else if (l == 7)
					result = 1;
				if (result == 1)
				{
					puts(name);
					puts(" has won the duel!");
					m = l = 0;
					break;
				}
				else if (result == 2)
				{
					puts("The computer has won the duel!");
					m = l = 0;
					break;
				}
				moves++;
			}
			printf("\n\nWould you like to play again in this mode?\nEnter Y for yes & anything else for no:");
			scanf(" %c", &playAgain);
			if (playAgain == 'Y' || playAgain == 'y')
			{
				for (int index = 0; index < 52; index++)
					free(deck[index]);
			}
			else
			{
				printf("\n\nWould you like to return the main menu? \nEnter Y for yes & anything else for no and to exit the game. ");
				scanf(" %c", &playAgain);
				if (playAgain == 'Y' || playAgain == 'y')
				{
					for (int index = 0; index < 52; index++)
						free(deck[index]);
					main();
				}
				else
					exit(0);
				break;
			}
		} while (1);
		break;
	case 2:
		rules(select);
		printf("Player1 name :");
		scanf("%s", name1);
		printf("Player2 name :");
		scanf("%s", name2);
		do
		{
			dealCards(playerHand, player2Hand, deck);
			int moves = 1;
			while (1)
			{
				printf("\n\nMoves:%d\n ", moves);
				PlayPlayer(playerHand, player2Hand, name1, name2);
				int result = checkPlayerWin(playerHand, player2Hand, name1, name2);
				if (lfor1 == 7)
					result = 2;
				if (lfor2 == 7)
					result = 1;
				if (result == 1 || result == 2)
				{
					if (result == 1)
						printf("%s", name1);
					else if (result == 2)
						printf("%s", name2);
					puts(" has won the duel");
					lfor2 = lfor1 = 0;
					break;
				}
				moves++;
			}
			printf("\n\nWould you like to play again in this mode?\nEnter Y for yes & anything else for no: ");
			scanf(" %c", &playAgain);
			if (playAgain == 'Y' || playAgain == 'y')
			{
				for (int index = 0; index < 52; index++)
					free(deck[index]);
			}
			else
			{
				printf("\n\nWould you like to return the main menu? \nEnter Y for yes & anything else for no and to exit the game: ");
				scanf(" %c", &playAgain);
				if (playAgain == 'Y' || playAgain == 'y')
				{
					for (int index = 0; index < 52; index++)
						free(deck[index]);
					main();
				}
				else
					exit(0);
				break;
			}
		} while (1);
		break;
	default:
		printf("Please re-run the program and enter a valid value. Thank you");
		exit(0);
		break;
	}while (1);
	return 0;
}//main

void rules(int select)//rules
{
	switch (select)
	{
	case 1:
		puts("You have selected the Computer VS Player mode.\n\nHow to PLAY THE GAME???.\n\n1) You will be given 26 cards.\n2) At each move, your card will be compared with the Opponent's card.\n3) Before the cards are displayed, you will have to make a guess and try your luck at it. Press 1 if you think you will win while press 0 if you think that the opponent will win that round. Each of the players will make alternate guesses.\n4) If the player guesses wrong,a P which stands for the PENALTY is given to the player. The next time the same person makes a wrong guess, E is given and then N, A, L...so on and so forth. \n5) The order of the ranks:\n\tSuits: Club♣, Diamond♦, Heart♥, Spades♠\n6) The order of the Ranks: Two, Three, Four, Five, Six, Seven, Eight, Nine, Ten, Jack, Queen, King, Ace.\n7) Whoever has the card of higher rank wins the pair and if at all the ranks are same, the higher suit will win the round.\n8) If a person wins a particular round, both the displayed cards are taken by the victor. \n WINNING CONDITIONS:\n1. The player has to have the full deck.\n2. If the opponent completes the word-PENALTY, the player wins the game by default.\nPLEASE NOTE: While guessing, 1 means you guess for yourself to will win the round and 0 for the opponent.\n\t\t** ALL THE BEST **\n\n");
		break;
	case 2:
		printf("You have selected the Player VS Player mode.\n\nHow to PLAY THE GAME???.\n\n1) You will be given 26 cards.\n2) At each move, your card will be compared with the Opponent's card.\n3) Before the cards are displayed, you will have to make a guess and try your luck at it. Press 1 if you think you will win while press 0 if you think that the opponent will win that round. Each of the players will make alternate guesses.\n4) If the player guesses wrong,a P which stands for the PENALTY is given to the player. The next time the same person makes a wrong guess, E is given and then N, A, L...so on and so forth. \n5) The order of the ranks:\n\tSuits: Club♣, Diamond♦, Heart♥, Spades♠\n6) The order of the Ranks: Two, Three, Four, Five, Six, Seven, Eight, Nine, Ten, Jack, Queen, King, Ace.\n7) Whoever has the card of higher rank wins the pair and if at all the ranks are same, the higher suit will win the round.\n8) If a person wins a particular round, both the displayed cards are taken by the victor. \n WINNING CONDITIONS:\n1. The player has to have the full deck \n2. If the opponent completes the word-PENALTY, the player wins the game by default. \nPLEASE NOTE: While guessing, 1 means you guess for yourself to will win the round and 0 for the opponent.\n\t\t** ALL THE BEST **\n\n");
	}
}//rules

void dealCards(Card* playerHand[], Card* compHand[], Card* deck[])//dealCards
{
	int cardsCreated = 0;
	int turn = 0;
	Card card;
	srand(time(NULL));
	while (cardsCreated < 52)
	{
		int cardFound = FALSE;
		card.rank = rand() % 13;
		card.suit = rand() % 4;
		for (int index = 0; index < cardsCreated; index++)
		{
			Card* deckCard = deck[index];
			if (deckCard->rank == card.rank && deckCard->suit == card.suit)
			{
				cardFound = TRUE;
				break;
			}
		}
		if (cardFound == FALSE)
		{
			if (turn == 0)
			{
				playerHand[cardsCreated / 2] = (Card*)malloc(sizeof(Card));
				playerHand[cardsCreated / 2]->suit = card.suit;
				playerHand[cardsCreated / 2]->rank = card.rank;
				deck[cardsCreated] = playerHand[cardsCreated / 2];
			}
			else if (turn == 1)
			{
				compHand[(cardsCreated - 1) / 2] = (Card*)malloc(sizeof(Card));
				compHand[(cardsCreated - 1) / 2]->suit = card.suit;
				compHand[(cardsCreated - 1) / 2]->rank = card.rank;
				deck[cardsCreated] = compHand[(cardsCreated - 1) / 2];
			}
			turn = (turn == 0) ? 1 : 0;
			cardsCreated++;
		}
	}
	for (int index = 26; index < 52; index++)
	{
		playerHand[index] = NULL;
		compHand[index] = NULL;
	}
}//dealCards

void playMove(Card* playerHand[], Card* compHand[])//playMove
{
	Card* playerCard = playerHand[0];
	Card* compCard = compHand[0];
	int pSuit = playerCard->suit;
	int pRank = playerCard->rank;
	int cSuit = compCard->suit;
	int cRank = compCard->rank;
	int result = compareCards(playerCard, compCard);
	int input, j;
	srand(time(NULL));
	j = rand();
	switch ((i++) % 2)
	{
	case 0:
		printf("Who do you think will win this round %s??\n\t", name);
		scanf("%d", &input);
		printf("\n");
		printf("\tPlayer's card: %s of %s\n\tComputer's card: %s of %s\n", RankNames[pRank], SuitNames[pSuit], RankNames[cRank], SuitNames[cSuit]);
		int r = checkGuess(playerCard, compCard, input);
		if (r)
			printcmpvsplayer(++m, l);
		else
			printcmpvsplayer(m, l);
		break;
	case 1:
		printf("Computer's guess : ");
		sleep(2);
		printf("%d", j % 2);
		printf("\n\tPlayer's card: %s of %s\n\tComputer's card: %s of %s\n", RankNames[pRank], SuitNames[pSuit], RankNames[cRank], SuitNames[cSuit]);
		r = checkGuess(playerCard, compCard, j % 2);
		if (r)
			printcmpvsplayer(m, l);
		else
			printcmpvsplayer(m, ++l);
	}
	for (int index = 1; index < 52; index++)//brilliant
	{
		playerHand[index - 1] = playerHand[index];
		compHand[index - 1] = compHand[index];
	}
	if (m != 7 || l != 7)
	{
		if (l != 7 || m != 7)
		{
			switch (result)
			{
			case 0:
				printf("\n\n%s wins the turn\n\n", name);
				int length = 0;
				for (int index = 0; index < 52; index++)
				{
					if (playerHand[index] != NULL)
						length++;
				}
				playerHand[length] = playerCard;
				playerHand[length + 1] = compCard;
				break;
			case 1:
				printf("\n\nComputer wins the turn\n\n");
				length = 0;
				for (int index = 0; index < 52; index++)
				{
					if (compHand[index] != NULL)
						length++;
				}
				compHand[length] = compCard;
				compHand[length + 1] = playerCard;
			}
		}
	}
}//playMove

int compareCards(Card* playerCard, Card* compCard)//compareCards
{
	int a;
	if (playerCard->rank > compCard->rank)
		a = 0;
	else if (playerCard->rank < compCard->rank)
		a = 1;
	else
	{
		if (playerCard->suit > compCard->suit)
			a = 0;
		else
			a = 1;
	}
	return a;
}//compareCards

int printcmpvsplayer(int k, int l)//printcmpvsplayer
{
	printf("\nWORD for %s: ", name);
	for (j = 0; j <= k; j++)
	{
		printf("%c", ab[j]);
		if (j == 7)
			return 0;
	}
	printf("\nWORD for Computer: ");
	for (j = 0; j <= l; j++)
	{
		printf("%c", ab[j]);
		if (j == 7)
			return 0;
	}
	return 0;
}//printcmpvsplayer

int checkWin(Card* playerHand[], Card* compHand[])//checkWin
{
	int playerLen = 0, compLen = 0;
	for (int i = 0; i < 52; i++)
	{
		if (playerHand[i] != NULL)
			playerLen++;
		if (compHand[i] != NULL)
			compLen++;
	}
	printf("%s's", name);
	printf("deck: %d", playerLen);
	printf("\nComputer's ");
	printf("deck: %d\n", compLen);
	printf("------------------------------------\n");
	if (playerLen == 52)
		return 1;
	if (compLen == 52)
		return 2;
	return -1;
}//checkWin

void PlayPlayer(Card* playerHand[], Card* player2Hand[], char name1[20], char name2[20])//PlayPlayer
{
	srand(time(0));
	Card* playercard = playerHand[0];
	Card* player2card = player2Hand[0];
	int psuit = playercard->suit;
	int prank = playercard->rank;
	int p2suit = player2card->suit;
	int p2rank = player2card->rank;
	int r, d1, d2, input;
	switch ((i++) % 2)
	{
	case 0:
		printf("Guess %s:", name1);
		scanf("%d", &input);
		printf("%s's cards:%s of %s\n", name1, RankNames[prank], SuitNames[psuit]);
		printf("%s's cards:%s of %s\n", name2, RankNames[p2rank], SuitNames[p2suit]);
		r = checkGuess(playercard, player2card, input);
		if (r)
			print(++lfor1, lfor2);
		else
			print(lfor1, lfor2);
		break;
	case 1:
		printf("Guess %s:", name2);
		scanf("%d", &input);
		printf("%s's cards:%s of %s\n", name1, RankNames[prank], SuitNames[psuit]);
		printf("%s's cards:%s of %s\n", name2, RankNames[p2rank], SuitNames[p2suit]);
		r = checkGuess(playercard, player2card, input);
		if (r)
			print(lfor1, lfor2);
		else
			print(lfor1, ++lfor2);
	}
	for (int index = 1; index < 52; index++)//brilliant
	{
		playerHand[index - 1] = playerHand[index];
		player2Hand[index - 1] = player2Hand[index];
	}
	if (lfor1 != 7)
	{
		if (lfor2 != 7)
		{
			r = compareCards(playercard, player2card);
			switch (r)
			{
			case 0:
				printf("\n\n%s wins the turn\n", name1);
				int length = 0;
				for (int index = 0; index < 52; index++)
				{
					if (playerHand[index] != NULL)
						length++;
				}
				playerHand[length] = playercard;
				playerHand[length + 1] = player2card;
				break;
			case 1:
				printf("\n\n%s wins the turn\n", name2);
				length = 0;
				for (int index = 0; index < 52; index++)
				{
					if (player2Hand[index] != NULL)
						length++;
				}
				player2Hand[length] = player2card;
				player2Hand[length + 1] = player2card;
			}
		}
	}
}//PlayPlayer

int checkGuess(Card* playercard, Card* compCard, int input)//checkGuessa
{
	if (input)
	{
		if (playercard->rank > compCard->rank)
			a = 0;
		else if (playercard->rank < compCard->rank)
			a = 1;
		else if (playercard->suit > compCard->suit)
			a = 0;
		else if (playercard->suit < compCard->suit)
			a = 1;
	}
	else
	{
		if (playercard->rank > compCard->rank)
			a = 1;
		else if (playercard->rank < compCard->rank)
			a = 0;
		else if (playercard->suit > compCard->suit)
			a = 1;
		else if (playercard->suit < compCard->suit)
			a = 0;
	}
	return a;
}//checkGuessa

int print(int l, int m)//print
{
	printf("\nWORD for %s: ", name1);
	for (j = 0; j <= l; j++)
	{
		printf("%c", ab[j]);
		if (j == 7)
			return 9;
	}
	printf("\nWORD for %s: ", name2);
	for (j = 0; j <= m; j++)
	{
		printf("%c", ab[j]);
		if (j == 7)
			return 9;
	}
	return 0;
}//print

int checkPlayerWin(Card* playerHand[], Card* player2Hand[], char name1[20], char name2[20])//checkPlayerWin
{
	int playerLen = 0, p2Len = 0;
	for (int i = 0; i < 52; i++)
	{
		if (playerHand[i] != NULL)
			playerLen++;
		if (player2Hand[i] != NULL)
			p2Len++;
	}
	printf("\n%s deck size: %d", name1, playerLen);
	printf("\n%s deck size: %d\n", name2, p2Len);
	printf("----------------------------------------------\n");
	if (playerLen == 52)
		return 1;
	if (p2Len == 52)
		return 2;
	return -1;
}//checkPlayerWin