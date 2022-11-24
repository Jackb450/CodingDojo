class BankAccount: 

    def __init__(self, interest, balance):
        self.interest = interest
        self.balance = balance

    def deposit(self, amount):
        self.balance += amount
        return self

    def withdraw(self, amount):
        if (self.balance - amount) < 0:
            print("Insufficient funds: Charging a $5 fee")
            self.balance -= (amount +5)
        else:
            self.balance -= amount
        return self

    def display_account_info(self):
        print(f"Balance: ${self.balance}")

    def yield_interest(self):
        if self.balance > 0:
            self.balance += self.balance * self.interest
        return self

acc1 = BankAccount(0.8, 500) 
acc2 = BankAccount(0.4, 700)

acc1.deposit(200).deposit(100).deposit(50).withdraw(60).yield_interest().display_account_info()
acc2.deposit(50).deposit(300).withdraw(55).withdraw(25).withdraw(70).withdraw(100).yield_interest().display_account_info()