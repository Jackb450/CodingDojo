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

    def account_info(self):
        return self.balance

    def yield_interest(self):
        if self.balance > 0:
            self.balance += self.balance * self.interest
        return self

class User:
    def  __init__ (self, name, email):
        self.name = name
        self.email = email
        self.account  = {
            "checking" : BankAccount(interest = 0.2, balance = 1000),
            "savings" : BankAccount(interest = 0.5, balance = 1300)
        }
    
    def user_deposit(self, amount):
        self.account["savings"].deposit(amount)
        return self
    
    def user_withdraw(self, amount):
        self.account["savings"].withdraw(amount)
        return self
    
    def user_balance(self):
        print(f"User: {self.name}, Checking: ${self.account['checking'].account_info()}")
        print(f"User: {self.name}, Savings: ${self.account['savings'].account_info()}")
        return 