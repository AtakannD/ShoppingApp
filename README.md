# ShoppingApp
In the app, the user has a fridge to fill and he/she can go to the mall to buy groceries.
When the user goes to the mall to shop, he/she has a basket with a size. The user adds products to the basket. During shopping, the user can check the items that are in the basket already. If an item that the user selects cannot be added to the basket because of exceeding the basket capacity, your program should print a warning message. Shopping is finished when the user enters finish shopping, or the basket is full.
The items in the inventory of the mall are listed together in “inventory.txt” file where each line is formed as:
item_name,item_compartment,item_weight(grams)
After finishing shopping, the user heads home to fill his/her fridge. The fridge has four compartment with their limited size
Each item has to be put into their corresponding compartment. During the program run, you should be able to check the status of the fridge (remaining capacities of each compartment). If some of the items cannot be put to their corresponding compartments according to their remaining capacity, your program has to print a warning message. (e.g. If the remaining capacity of Vegetables and Fruits is 200 grams and you try to add a tomato to the fridge, the program should print a message like “tomato cannot be added to the fridge”).
After filling the fridge, the user can go shopping again, and return back to fill his/her fridge. Your program should end when the user enters exit, or all compartments are full.
