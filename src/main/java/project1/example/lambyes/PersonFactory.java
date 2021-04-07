package project1.example.lambyes;

interface PersonFactory<P extends Person> {
    P create(String firstName, String lastName);
}
