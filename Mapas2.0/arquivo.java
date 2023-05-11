public class MainActivity extends AppCompatActivity {


    private TextView Resultado;

    private PhotoView imagemEstado;

    private ImageView imagemBandeira;
    
    private RadioButton radioButtonParana;
    private RadioButton radioButtonSantaCatarina;
    private RadioButton radioButtonRioGrande;
    private RadioGroup estados;
       
    private CheckBox checkBoxEstado;
    private CheckBox checkBoxArea;
    private CheckBox checkBoxPop;
    private CheckBox checkBoxDensi;
    private CheckBox checkBoxid;
    private CheckBox checkBoxnum_m;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        entradaEstados = findViewById(R.id.entradaEstado);

        imagemEstado = (PhotoView) findViewById(R.id.imagemEstado);
        imagemBandeira = findViewById(R.id.imagenBandeira);

        Resultado = findViewById(R.id.Resultado);
        
        radioButtonParana = findViewById(R.id.radioButtonParana);
        radioButtonSantaCatarina = findViewById(R.id.radioButtonSantaCatarina);
        radioButtonRioGrande = findViewById(R.id.radioButtonRioGrande);
        estados = findViewById(R.id.estados);
       
        checkBoxEstado = findViewById(R.id.checkBoxEstado);
        checkBoxArea = findViewById(R.id.checkBoxArea);
        checkBoxPop = findViewById(R.id.checkBoxPop);
        checkBoxDensi = findViewById(R.id.checkBoxDensi);
        checkBoxid = findViewById(R.id.checkBoxid);
        checkBoxnum_m = findViewById(R.id.checkBoxnum_m);

        imagemEstado.setImageResource(R.drawable.tresestados);
        
        radioButtonListener();
        
    }

    public void radioButtonListener(){
        estados.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                if (checkedId == R.id.radioButtonParana){
                    imagemEstado.setImageResource(R.drawable.pr);
                    imagemBandeira.setVisibility(View.VISIBLE);
                    imagemBandeira.setImageResource(R.drawable.bpr);
                    checkboxParana();
                } else if (checkedId == R.id.radioButtonSantaCatarina){
                    imagemEstado.setImageResource(R.drawable.sc);
                    imagemBandeira.setVisibility(View.VISIBLE);
                    imagemBandeira.setImageResource(R.drawable.bsc);
                    checkboxSantaCatarina();
                } else if (checkedId == R.id.radioButtonSantaCatarina){
                    imagemEstado.setImageResource(R.drawable.rs);
                    imagemBandeira.setVisibility(View.VISIBLE);
                    imagemBandeira.setImageResource(R.drawable.brs);
                    checkboxRioGrande();
                }
            }
        }
    }
   
        public void checkboxParana(){
            
            String rr = "";

        if (checkBoxEstado.isChecked()){
            rr += "Estado: Parana \n";
        } if (checkBoxArea.isChecked()){
            rr += "Area: 199.298,981 km2 \n";
        } if (checkBoxPop.isChecked()){
            rr += "População: 11.597.484 hab \n";
        } if (checkBoxDensi.isChecked()){
            rr += "Densidade: 52,40 hab/km2 \n";
        } if (checkBoxid.isChecked()){
            rr += "IDH: 0,749 \n";
        } if (checkBoxnum_m.isChecked()){
            rr += "municipios: 284 \n";
        }
        Resultado.setText(rr);
        }
       
       
        public void checkboxSantaCatarina(){

        String rr = "";

        if (checkBoxEstado.isChecked()){
            rr += "Estado: Santa Catarina \n";
        } if (checkBoxArea.isChecked()){
            rr += "Area: 95.730,690 km2 \n";
        } if (checkBoxPop.isChecked()){
            rr += "População: 7.338.473 hab \n";
        } if (checkBoxDensi.isChecked()){
            rr += "Densidade: 65,29 hab/km2 \n";
        } if (checkBoxid.isChecked()){
            rr += "IDH: 0,774 \n";
        } if (checkBoxnum_m.isChecked()){
            rr += "municipios: 295 \n";
        }
        Resultado.setText(rr);
        }
       
        public void checkboxRioGrande(){

        String rr = "";

        if (checkBoxEstado.isChecked()){
            rr += "Estado: Rio Grande do Sul \n";
        } if (checkBoxArea.isChecked()){
            rr += "Area: 281.707,151 km2 \n";
        } if (checkBoxPop.isChecked()){
            rr += "População: 11.466.630 hab \n";
        } if (checkBoxDensi.isChecked()){
            rr += "Densidade: 39,79 hab/km2 \n";
        } if (checkBoxid.isChecked()){
            rr += "IDH: 0,746 \n";
        } if (checkBoxnum_m.isChecked()){
            rr += "municipios: 497 \n";
        }
        Resultado.setText(rr);
        
        }



}
