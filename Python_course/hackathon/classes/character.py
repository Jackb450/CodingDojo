class Character:
    def __init__(self):
        self.health = 100
        self.stamina = 10
        self.strength = 10
        self.defense = 5
        self.stun = False
        self.bleed = 0

    def attack(self, target):
        target.health -= self.strength - target.defense

    def heal(self):
        print("+++")
        self.health += self.stamina
