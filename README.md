# Задание для урока 5.
## Основы ООП.
1. Реализовать сущность, которая будет использоваться для хранения контактов в телефоне. Контакт представляет собой пару значений телефон-имя, например “89003337788 - Вася”.
Одному контакту может соответствовать несколько разных телефонов
Можно добавить новый контакт. Если происходит попытка добавления существующего контакта, то ничего не меняется.
Можно найти телефон, указав имя контакта. Если такого контакта нет, возвращается null. Если контакт есть, то возвращается массив телефонов.
Можно получить массив всех контактов, указав часть имени.

2. Реализовать иерархию классов геометрических фигур в плоской системе координат – точка, прямая, окружность, треугольник, квадрат, прямоугольник, параллелограмм.
Каждая сущность должна задаваться минимально необходимым количеством параметров и иметь методы, возвращающие её параметры – тип фигуры, длина линий, из которых она состоит (для точки константа 0, для прямой – длина, для окружности – длина окружности, для остальных периметр), площадь (для точки и прямой константа 0). Необходимо создать коллекцию (массив) разных фигур и в цикле вывести в консоль их параметры.

3. Разработать собственный класс, который можно использовать как перечисление.