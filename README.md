# object oriented programming exercise 1:

in this exercise we are implementing observer design pattern by GroupAdmin - ConcreteMember example (which are implementing sender-member interfaces).
ConcreteMember is a member who can register to a GroupAdmin and holds a GroupAdmin and UndoableStringBuilder objects.
GroupAdmin holds a UndoableStringBuilder object and a list of his members.
UndoableStringBuilder object is a StringBuilder object which has an undo operation.
in every change of the GroupAdmin UndoableStringBuilder object , it notifies all its members about the change.
then each member is updating its UndoableStringBuilder object to it.

The Observer design pattern is a behavioral design pattern that allows an object (called the subject) to notify other objects (called observers) when its state changes.
This pattern is used to create a one-to-many dependency between objects, so that when the state of the subject changes, all of its observers
are notified and updated automatically.
The Observer pattern has three main components:

Subject: The subject is an object that maintains a list of its observers and provides an interface for adding or removing observers.
The subject also has some state that it needs to keep track of, and it may provide methods for accessing this state.

Observer: The observer is an object that wants to be notified when the state of the subject changes.
It implements an interface that allows it to be registered with the subject as an observer.

Client: The client is the object that creates the subject and observer objects and establishes the relationship between them.

In the Observer design pattern, the subject maintains a list of its observers and provides methods for adding or removing observers.
When the state of the subject changes, it calls a method on each of its observers to notify them of the change.
The observers can then use the updated state of the subject to perform any necessary actions.

This pattern is useful for situations where an object needs to be notified when the state of another object changes, and it is particularly useful in GUI applications
where the state of a component (such as a button or text field) needs to be updated based on the state of another component (such as a model).
