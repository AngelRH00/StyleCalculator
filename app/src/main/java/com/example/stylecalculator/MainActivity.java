package com.example.stylecalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private String n1 = "";
    private String n2 = "";
    private String operador = "";
    private boolean numberOne = true;
    private TextView mostrar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    //NUMEROS
    public void cero(View view) {
        mostrar = findViewById(R.id.mostrar);
        if (numberOne) {
            n1 += "0";
        } else {
            n2 += "0";
        }
        muestra();
    }

    public void uno(View view) {
        mostrar = findViewById(R.id.mostrar);
        if (numberOne) {
            n1 += "1";
        } else {
            n2 += "1";
        }
        muestra();
    }

    public void dos(View view) {
        mostrar = findViewById(R.id.mostrar);
        if (numberOne) {
            n1 += "2";
        } else {
            n2 += "2";
        }
        muestra();
    }

    public void tres(View view) {
        mostrar = findViewById(R.id.mostrar);
        if (numberOne) {
            n1 += "3";
        } else {
            n2 += "3";
        }
        muestra();
    }

    public void cuatro(View view) {
        mostrar = findViewById(R.id.mostrar);
        if (numberOne) {
            n1 += "4";
        } else {
            n2 += "4";
        }
        muestra();
    }

    public void cinco(View view) {
        mostrar = findViewById(R.id.mostrar);
        if (numberOne) {
            n1 += "5";
        } else {
            n2 += "5";
        }
        muestra();
    }

    public void seis(View view) {
        mostrar = findViewById(R.id.mostrar);
        if (numberOne) {
            n1 += "6";
        } else {
            n2 += "6";
        }
        muestra();
    }

    public void siete(View view) {
        mostrar = findViewById(R.id.mostrar);
        if (numberOne) {
            n1 += "7";
        } else {
            n2 += "7";
        }
        muestra();
    }

    public void ocho(View view) {
        mostrar = findViewById(R.id.mostrar);
        if (numberOne) {
            n1 += "8";
        } else {
            n2 += "8";
        }
        muestra();
    }

    public void nueve(View view) {
        mostrar = findViewById(R.id.mostrar);
        if (numberOne) {
            n1 += "9";
        } else {
            n2 += "9";
        }
        muestra();
    }

    //OPERADORES
    public void mas(View view) {
        mostrar = findViewById(R.id.mostrar);
        if (numberOne) {
            operador = "+";
            numberOne = false;
        } else {
            calculoContinuo();
            operador = "+";
            n2 = "";
        }
    }

    public void menos(View view) {
        mostrar = findViewById(R.id.mostrar);
        if (numberOne) {
            operador = "-";
            numberOne = false;
        } else {
            calculoContinuo();
            operador = "-";
            n2 = "";
            mostrar.setText(n1);
        }
    }

    public void por(View view) {
        mostrar = findViewById(R.id.mostrar);
        if (numberOne) {
            operador = "*";
            numberOne = false;
        } else {
            calculoContinuo();
            operador = "*";
            n2 = "";
        }
    }

    public void dividido(View view) {
        mostrar = findViewById(R.id.mostrar);
        if (numberOne) {
            operador = "/";
            numberOne = false;
        } else {
            calculoContinuo();
            operador = "/";
            n2 = "";
        }
    }

    //ACCIONES
    public void reiniciar(View view) {
        mostrar = findViewById(R.id.mostrar);
        n1 = "";
        n2 = "";
        operador = "";
        numberOne = true;
        mostrar.setText("Calculator");
    }

    public void coma(View view) {
        mostrar = findViewById(R.id.mostrar);
        if (numberOne) {
            if (!n1.contains(".")) n1 += ".";

        } else {
            if (!n2.contains(".")) n2 += ".";
        }
        muestra();
    }

    public void igual(View view) {
        try {
            if (n1.endsWith(".") || n2.endsWith(".")) throw new IllegalArgumentException();
            calculo();
        } catch (IllegalArgumentException i) {
            mostrar.setText("Numbers can't end with a comma!");
        }

    }

    public void calculo() {
        mostrar = findViewById(R.id.mostrar);
        try {
            if (n1.equals("")) throw new IllegalArgumentException();
            if (numberOne) {

            } else {
                switch (operador) {
                    case "+":
                        if (n2.equals("")) mostrar.setText(n1 + "+?");
                        else {
                            mostrar.setText(String.valueOf(Double.parseDouble(n1) + Double.parseDouble(n2)));
                            n1 = String.valueOf(Double.parseDouble(n1) + Double.parseDouble(n2));
                        }
                        break;
                    case "-":
                        if (n2.equals("")) mostrar.setText(n1 + "-?");

                        else {
                            mostrar.setText(String.valueOf(Double.parseDouble(n1) - Double.parseDouble(n2)));
                            n1 = String.valueOf(Double.parseDouble(n1) - Double.parseDouble(n2));
                        }
                        break;
                    case "*":
                        if (n2.equals("")) mostrar.setText(n1 + "×?");
                        else {
                            mostrar.setText(String.valueOf(Double.parseDouble(n1) * Double.parseDouble(n2)));
                            n1 = String.valueOf(Double.parseDouble(n1) * Double.parseDouble(n2));
                        }
                        break;
                    case "/":
                        if (n2.equals("")) mostrar.setText(n1 + "÷?");
                        else {
                            try {
                                if (n2.equals("0")) throw new ArithmeticException();
                                mostrar.setText(String.valueOf(Double.parseDouble(n1) / Double.parseDouble(n2)));
                                n1 = String.valueOf(Double.parseDouble(n1) / Double.parseDouble(n2));
                            } catch (ArithmeticException a) {
                                mostrar.setText("You can't divide by zero!");
                            }

                        }
                        break;
                    default:
                        break;

                }
                n2="";
            }
        } catch (IllegalArgumentException i) {
            mostrar.setText("Number 1 is empty!");
            n1 = "";
            n2 = "";
            numberOne = true;
        }
    }

    public void calculoContinuo() {
        mostrar = findViewById(R.id.mostrar);
        try {
            if (n1.equals("")) throw new IllegalArgumentException();
                switch (operador) {
                    case "+":
                        if (n2.equals("")) mostrar.setText(n1 + "+?");
                        else {
                            mostrar.setText(String.valueOf(Double.parseDouble(n1) + Double.parseDouble(n2)));
                            n1 = String.valueOf(Double.parseDouble(n1) + Double.parseDouble(n2));
                        }
                        break;
                    case "-":
                        if (n2.equals("")) mostrar.setText(n1 + "-?");

                        else {
                            mostrar.setText(String.valueOf(Double.parseDouble(n1) - Double.parseDouble(n2)));
                            n1 = String.valueOf(Double.parseDouble(n1) - Double.parseDouble(n2));
                        }
                        break;
                    case "*":
                        if (n2.equals("")) mostrar.setText(n1 + "×?");
                        else {
                            mostrar.setText(String.valueOf(Double.parseDouble(n1) * Double.parseDouble(n2)));
                            n1 = String.valueOf(Double.parseDouble(n1) * Double.parseDouble(n2));
                        }
                        break;
                    case "/":
                        if (n2.equals("")) mostrar.setText(n1 + "÷?");
                        else {
                            try {
                                if (n2.equals("0")) throw new ArithmeticException();
                                mostrar.setText(String.valueOf(Double.parseDouble(n1) / Double.parseDouble(n2)));;
                                n1 = String.valueOf(Double.parseDouble(n1) / Double.parseDouble(n2));
                            } catch (ArithmeticException a) {
                                mostrar.setText("You can't divide by zero!");
                            }

                        }
                        break;
                    default:
                        break;



            }
        } catch (IllegalArgumentException i) {
            mostrar.setText("Number 1 is empty!");
            n1 = "";
            n2 = "";
            numberOne = true;
        }
    }

    public void muestra() {
        mostrar = findViewById(R.id.mostrar);
        if (numberOne) mostrar.setText(n1);
        else mostrar.setText(n2);
    }
}
