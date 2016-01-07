class Player(object):

    def __init__(self):
        self.hand = []

    def getTotal(self):
        sum = 0
        aces = 0
        for c in self.hand:
            if c.getName() == "Ace":
                aces += 1
                sum += 11
            elif c.getName() == "Jack" or c.getName() == "Queen" or c.getName() == "King":
                sum += 10
            else:
                val = c.getValue()
                sum += val
        while aces > 0:
            aces -= 1
            if sum > 21:
                sum -= 10
            else:
                break
        return sum

    def addToHand(self, card):
        self.hand.append(card)

    def showHand(self, type):
        if type == "DealerH":
            print ("Dealer Cards: ", self.hand[0].getName(), "of", self.hand[0].getSuit())

        elif type == "Player" or "Dealer":
            print (type, "Cards: ",)
            for c in self.hand:
                print (c.getName(), "of", c.getSuit(),)
            print ()
            print ("Total: ", self.getTotal())

    def dealerHand(self, deck):
        if self.getTotal() < 17:
            self.addToHand(deck.cards.pop())
            return True
        else:
            return False
