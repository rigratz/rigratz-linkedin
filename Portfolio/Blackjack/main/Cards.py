import random

class Deck(object):
    cards = []

    def __init__(self):
        self.createDeck()

    def createDeck(self):
        suits = ["Hearts", "Diamonds", "Clubs", "Spades"]
        for s in suits:
            for i in range(1, 14):

                if i == 1:
                    name = "Ace"
                    value = 11
                elif i == 11:
                    name = "Jack"
                    value = 10
                elif i == 12:
                    name = "Queen"
                    value = 10
                elif i == 13:
                    name = "King"
                    value = 10
                else:
                    value = name = i
                #print(value, name)

                newCard = Card(s, value, name)
                self.cards.append(newCard)

    def shuffle(self):
        temp = []
        while len(self.cards) > 0:
            r = self.cards[random.randrange(0, len(self.cards))]
            temp.append(r)
            self.cards.remove(r)
        self.cards = temp

class Card(object):

    def __init__(self, suit, value, name):
        self.suit = suit
        self.value = value
        self.name = name

    def getSuit(self):
        return self.suit

    def getValue(self):
        return self.value

    def getName(self):
        return self.name