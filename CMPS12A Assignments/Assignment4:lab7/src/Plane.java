class Plane {
    private Shape[] shapes;
    private int index = 0;

    public Plane() {
        shapes = new Shape[0];
    }
    public Shape[] getShape() {
        return shapes;
    }

    public void addShape(Shape shape) {
        Shape[] dummy = new Shape[shapes.length + 1];
        for (int i = 0; i < shapes.length; i++) {
            dummy[i] = shapes[i];
        }
        shapes = dummy;
        shapes[shapes.length - 1] = shape;
    }

    public double getSumOfAreas() {
        double total = 0;
        for (int i = 0; i < shapes.length; i++) {
            total += shapes[i].getArea();
        }
        return total;
    }

    public double getSumOfPerimeters() {
        double total = 0;
        for (int i = 0; i < shapes.length; i++) {
            total += shapes[i].getPerimeter();
        }
        return total;
    }

    public Point getCenterOfPointOfSymmetries() {
        double x = 0.0, y = 0.0;
        double X = 0, Y = 0;
        for (Shape s : shapes) {
            if (s instanceof Symmetric) {
                x += ((Symmetric) s).getPointOfSymmetry().getX();
                y += ((Symmetric) s).getPointOfSymmetry().getY();
                X++;
                Y++;
            }
        }
        if (X > 0)
            return new Point(x/X, y/Y);
        else
            return null;
    }
}


