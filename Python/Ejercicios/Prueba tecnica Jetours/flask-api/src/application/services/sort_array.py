from typing import List
import abc



class AbstractSortArray(abc.ABC):

    @abc.abstractmethod
    def check_array_type(self, array:List) -> bool:
        """Check this the array only contains numeric"""

    @abc.abstractmethod
    def sort(self, array:List) -> List:
        """Sorts a list according to the chosen method"""


class BubbleSort(AbstractSortArray):

    def check_array_type(self, array:List) -> bool:
        return (all([isinstance(item, int) for item in array]))

    def sort(self, array:List) -> List:
        n = len(array)
        swapped = False
        for i in range(n - 1):
            for j in range(0, n - i - 1):
                if array[j] > array[j + 1]:
                    swapped = True
                    array[j], array[j + 1] = array[j + 1], array[j]
            if not swapped:
                return
        return array
