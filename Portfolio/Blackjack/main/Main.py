import math

import random

from main.Cards import Deck
from main.Players import Player

deckOfCards = Deck()

def getFibNum(num):
        if num == 1 or num == 0:
            return 1
        else:
            return getFibNum(num - 2) + getFibNum(num - 1)

def isPrime(num):
    for i in range(2, int(math.sqrt(num)) + 1):
        if num % i == 0:
            return False

    return True

def main():
    #print ("Random dice roll:", random.randrange(1, 7))
    #print ("Fibonacci number 10:", getFibNum(10))
    #print ("17 is a Prime Number:", isPrime(17))

    deckOfCards.shuffle()

    player = Player()
    dealer = Player()

    players = [dealer, player]

    dealCards(players, deckOfCards)

    players[0].showHand("DealerH")


    looper = True
    bust = False
    while players[1].getTotal() < 21 and looper:
        players[1].showHand("Player")
        looper = movePrompt(players[1])

    players[1].showHand("Player")

    if (players[1].getTotal() > 21):
        bust = True
        print ("Bust!")


    looper = True
    while looper:
        players[0].showHand("Dealer")
        looper = players[0].dealerHand(deckOfCards)

    dealBust = False
    if players[0].getTotal() > 21:
        dealBust = True

    if players[1].getTotal() > players[0].getTotal() and not bust and not dealBust:
        print ("You win!")
    elif players[1].getTotal() == players[0].getTotal() and not bust and not dealBust:
        print ("Push!")
    elif not bust and dealBust:
        print ("Dealer busts! You win!")
    else:
        print ("You lose.")


def movePrompt(player):
    print ("Select a move:")
    print ("1: Hit")
    print ("2: Stay")
    selection = int(input("Make selection:"))

    if selection == 1:
        print ("Hit me!")
        player.addToHand(deckOfCards.cards.pop())
    elif selection == 2:
        return False

    return True

def dealCards(players, deck):
    for i in range(2):
        for p in players:
            card = deck.cards.pop()
            p.addToHand(card)

if __name__ == '__main__':
        main()







