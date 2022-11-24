from random import random
from classes.character import Character

class Pirate(Character):
    def __init__(self):
        super().__init__()  #adds atriubutes from previos construct
        self.stamina = 5
        self.defense = 10
        self.weapon = 7


    def attack(self, target):
        print("Argh!")
        damage = self.strength + self.weapon - target.defense
        target.health -= damage
        """
        roll = random.randint(1,20)
        if (roll > 18):
            target.health -= self.weapon_damage
"""
    def stab(self, target):
        print("Ye-argh!")
        bleeddam = 2
        target.bleed += bleeddam

# NERRRRFFF BLEEEDDD T_T; TOO OP BIG CRY
