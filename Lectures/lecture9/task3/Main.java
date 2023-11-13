/**
 * A Main class that uses the classes Course and Catalog 
 *
 * @author Gabriela Montoya
 * @version 1.3, 2023-11-03
 */
 
class Main {
    
    public static void main(String[] args) {
    
        String[] codes = { "OOP", "SU", "DEB" };
        String[] titles = { "Object-oriented programming", "Systems Development",
                            "Design and evaluation of user interfaces"};
        String[] semesters = { "SW3", "DAT3" };
        Catalog catalog = null; 
        for (int i = 0; i < codes.length; i++) {
            Course c =  new Course(codes[i], titles[i]);
            for (int j = 0; j < semesters.length; j++) {
                c.addSemester(semesters[j]);
            }
            if (catalog == null) {
                catalog = new Catalog(c);
            } else {
                catalog.addCourse(c);
            }
        }
        System.out.println("Catalog formatted according to its structure:");
        System.out.println(catalog);
        
        System.out.println("Catalog with courses ordered by title");
        System.out.println(catalog.inorder());
    }
}