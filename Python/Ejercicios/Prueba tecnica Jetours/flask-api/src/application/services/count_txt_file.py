from ..exceptions import WrongFilePathException


class CountCapitalLettersTxtFile:

    def count_capital_letters(self, text: str) -> int:
        counter = 0
        for c in text:
            if c.isupper():
                counter += 1
        
        return counter    

