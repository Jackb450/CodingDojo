from classes.ninja import Ninja
from classes.pirate import Pirate
import random

ninja = Ninja()
pirate = Pirate()

print(ninja.__class__ == Ninja)

print("Welcome to Pirates vs. Ninjas!")
response = input("Select your character 1)Ninja 2)Pirate: ")
if response == "1":
    print("You are playing the Ninja")
    while ninja.health > 0 and pirate.health > 0:

        if ninja.bleed > 0:
            ninja.health -= ninja.bleed
        if ninja.bleed >= 0:
            ninja.bleed -= .5
        response = input("Will you 1)Attack 2)Heal 3)Stun: ")
        if response == "1":
            ninja.attack(pirate)
        if response == "2":
            ninja.heal()
        if response == "3":
            ninja.stunned(pirate)
        if pirate.stun == False:
            roll = random.randint(1, 3)
            if roll == 1:
                pirate.attack(ninja)
            if roll == 2:
                pirate.heal()
            if roll == 3:
                pirate.stab(ninja)
        if pirate.stun == True:
            print("enemy stunned")
            pirate.stun = False
        print(f"Ninja's health is {ninja.health}")
        print(f"Pirate's health is {pirate.health}")


if response == "2":
    print("You are playing the Pirate")
    while ninja.health > 0 and pirate.health > 0:

        if ninja.bleed > 0:
            ninja.health -= ninja.bleed
        if ninja.bleed >= 0:
            ninja.bleed -= .5
        if pirate.stun == False:
            response = input("Will you 1)Attack 2)Heal 3)Stab: ")
            if response == "1":
                pirate.attack(ninja)
            if response == "2":
                pirate.heal()
            if response == "3":
                pirate.stab(ninja)
        roll = random.randint(1, 3)
        if roll == 1:
            ninja.attack(pirate)
        if roll == 2:
            ninja.heal()
        if roll == 3:
            ninja.stunned(pirate)
        if pirate.stun == True:
            print("stun't lol")
            pirate.stun = False

        print(f"Ninja's health is {ninja.health}")
        print(f"Pirate's health is {pirate.health}")


print("game over")
