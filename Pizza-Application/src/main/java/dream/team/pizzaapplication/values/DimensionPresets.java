package dream.team.pizzaapplication.values;

import static dream.team.pizzaapplication.values.DimensionPresets.Surrounding.*;

public class DimensionPresets {
    static class Surrounding {
        static final int quarter_spacing = 2;
        static final int half_spacing = 4;
        static final int spacing = 8;
        static final int double_spacing = 16;
        static final int triple_spacing = 24;
        static final int quadruple_spacing = 32;
        static final int quintuple_spacing = 40;
        static final int sextuple_spacing = 48;
        static final int septuple_spacing = 56;
        static final int octuple_spacing = 64;
        static final int nonuple_spacing = 72;
    }

    public static class Spacing {
        static class Horizontal {
            public  static final int xxs = quarter_spacing;
            public static final int xs = half_spacing;
            public static final int s = spacing;
            public static final int m = double_spacing;
            public static final int l = triple_spacing;
            public static final int xl = quadruple_spacing;
            public static final int xxl = quintuple_spacing;
            public static final int xxxl = sextuple_spacing;
            public static final int xl4 = septuple_spacing;
            public static final int xl5 = octuple_spacing;
            public static final int xl7 = nonuple_spacing;
        }

        public static class Vertical {
            public static final int xxs = quarter_spacing;
            public static final int xs = half_spacing;
            public static final int s = spacing;
            public static final int m = double_spacing;
            public static final int l = triple_spacing;
            public static final int xl = quadruple_spacing;
            public static final int xxl = quintuple_spacing;
            public static final int xxxl = sextuple_spacing;
            public static final int xl4 = septuple_spacing;
        }

        public static class Surrounding {
            public static final int xxs = quarter_spacing;
            public static final int xs = half_spacing;
            public static final int s = spacing;
            public static final int m = double_spacing;
            public static final int l = triple_spacing;
            public static final int xl = quadruple_spacing;
            public static final int xxl = quintuple_spacing;
            public static final int xxxl = sextuple_spacing;
            public static final int xl4 = septuple_spacing;
        }
    }

    public static class TextSize {
        public static final int xxs = 12;
        public static final int xs = 14;
        public static final int s = 16;
        public static final int m = 18;
        public static final int l = 22;
        public static final int xl = 26;
        public static final int xxl = 32;
        public static final int xxxl = 42;
        public static final int xl4 = 64;
    }

    public static class CornerRadius {
        public static final int xxs = 1;
        public static final int xs = 2;
        public static final int s = 4;
        public static final int m = 6;
        public static final int l = 12;
    }

    public static class TextFieldSize {
        public static final int s = 25;
        public static final int m = 50;
        public static final int xm = 55;
        public static final int l = 100;
        public static final int xl = 150;
        public static final int xxl = 200;
        public static final int xxxl = 250;
        public static final int xl4 = 300;
        public static final int xl5 = 350;
    }
    public static class HBox {
        public static final int s = 25;
        public static final int m = 50;
        public static final int xm = 55;
        public static final int l = 100;
        public static final int xl = 150;
        public static final int xxl = 200;
        public static final int xxxl = 250;
        public static final int xl4 = 275;
        public static final int xl5 = 300;
        public static final int xl6 = 350;
    }
    public static class VBox {
        public static final int s = 25;
        public static final int m = 50;
        public static final int xm = 55;
        public static final int l = 100;
        public static final int xl = 150;
        public static final int xxl = 200;
        public static final int xxxl = 250;
        public static final int xl4 = 275;
        public static final int xl5 = 300;
        public static final int xl6 = 350;
    }

    public static class ImageSize {
        public static final int xs = 25;
        public static final int s = 35;
        public static final int m = 50;
        public static final int l = 100;
        public static final int xl = 150;
        public static final int xxl = 200;
        public static final int xxxl = 250;
        public static final int xl4 = 300;
        public static final int xl5 = 350;
    }

    public static class IconSize {
        public static final int xs = 15;
        public static final int s = 20;
        public static final int m = 25;
        public static final int l = 30;
        public static final int xl = 35;
        public static final int xxl = 40;
        public static final int xxxl = 50;
        public static final int xl4 = 60;
        public static final int xl5 = 70;
        public static final int xl6 = 80;
    }

    public static class ButtonSize {
        public static final int s = 25;
        public static final int m = 50;
        public static final int l = 100;
        public static final int xl = 150;
        public static final int xxl = 200;
        public static final int xxxl = 250;
        public static final int xl4 = 300;
        public static final int xl5 = 350;
    }

    public static class Transparency {
        public static final double xxs = 0.90;
        public static final double xs = 0.75;
        public static final double s = 0.50;
        public static final double m = 0.25;
        public static final double l = 0.10;
        public static final double xl = 0.05;
        public static final double xxl = 0.03;
    }
}