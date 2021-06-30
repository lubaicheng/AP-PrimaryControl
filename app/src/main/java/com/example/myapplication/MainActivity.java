package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;


import org.w3c.dom.Text;

import static com.example.myapplication.R.string.copy_right;
//添加代码

public class MainActivity extends AppCompatActivity {
    private Button btn1=null,btn2=null;
    private EditText userid=null,pwd=null;
    private RadioGroup radioGroup;
    private String sex;
    private CheckBox cb1,cb2,cb3;
    private String msg1,msg2,msg3;
    private TextView text1;
//    private RadioButton rb1,rb2;
    private String userInfo,userpwd;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        this.getResources().getDrawable(R.mipmap.ic_launcher);
        cb1=findViewById(R.id.cb1);
        cb2=findViewById(R.id.cb2);
        cb3=findViewById(R.id.cb3);
        text1=findViewById(R.id.text1);
        userid=findViewById(R.id.userid);
        pwd=findViewById(R.id.pwd);
        radioGroup=findViewById(R.id.radiogroup);
        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            //group接收的就是radiogroup对象本身， 用户选择哪一个按钮，就会把这个按钮的ID传给checkId
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                if (checkedId==R.id.rb1){
                    sex="男";
                }
                else if(checkedId==R.id.rb2){
                    sex="女";
                }

            }
        });
        //写一个监听器(CheckBox)
        CompoundButton.OnCheckedChangeListener occl=new CompoundButton.OnCheckedChangeListener() {
            @Override
            //buttonView:传递回checkbox对象，ischecked:传递过来的是选项是否被选中，选中true，没选中就是false;
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(buttonView.getId()==R.id.cb1){
                    if(isChecked){
                        msg1="篮球";
                    }else{
                        msg1="null";
                    }
                }
                if(buttonView.getId()==R.id.cb2){
                    if(isChecked){
                        msg2="乒乓球";
                    }else{
                        msg2="null";
                    }
                }
                if(buttonView.getId()==R.id.cb3){
                    if(isChecked){
                        msg3="排球";
                    }else{
                        msg3="null";
                    }
                }
//                boolean ischeck=isChecked;
//                Toast.makeText(MainActivity.this, msg1+msg2+msg3, Toast.LENGTH_SHORT).show();
            }
        };
        cb1.setOnCheckedChangeListener(occl);
        cb2.setOnCheckedChangeListener(occl);
        cb3.setOnCheckedChangeListener(occl);



//        btn1=findViewById(R.id.btn1);
//        btn2=findViewById(R.id.btn2);
        /*
        * 按钮触发方式2：通过匿名内部类的方式实现。
        * */
//        btn2.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                btn2.setText("按钮二被点击了");
//            }
//        });


    }

    public void myclick(View view) {
        userInfo=userid.getText().toString();
        userpwd=pwd.getText().toString();
        Toast.makeText(MainActivity.this,"用户名是："+userInfo+"输入的密码"+userpwd+"你的性别是:"+sex+"你的爱好是："+msg1+msg2+msg3,Toast.LENGTH_SHORT).show();
    }

    public void click(View view) {
        //运行一个对话框
        //对话框的步骤：
        /*1:普通对话框：
        *创建对话框的builder对象，该对象用于构建一个对话框的模板
        * builder对象,调用create()方法创建一个对话框对象，该对象调用show()方法就可以运行
        *
        *
        * */
        AlertDialog.Builder builder=new AlertDialog.Builder(this);
        //构建对话框模型
        builder.setIcon(R.mipmap.ic_launcher)
                .setTitle("退出！")
                .setMessage("确定退出？不再玩一会？")
                .setPositiveButton("确定", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        //关闭Dialog对话框
                        dialog.dismiss();
                        //关闭app
                        MainActivity.this.finish();
                    }
                })
                .setNegativeButton("取消", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        //关闭Dialog对话框
                        dialog.dismiss();
                    }
                });

        //下面也可以写成：builder.create().show();
        AlertDialog adialog=builder.create();
        adialog.show();
//

    }
    int index=0;
    public void click2(View view) {

        AlertDialog.Builder builder=new AlertDialog.Builder(this);
        String[] showMsg=new String[]{"默认","小号","中号","大号"};
        int[] textsize=new int[]{10,20,30,40};

        //构建对话框模型
        builder.setIcon(R.mipmap.ic_launcher)
                .setTitle("调整字体大小")
                .setSingleChoiceItems(showMsg, index, new DialogInterface.OnClickListener() {
                    @Override
                    //dialog这个返回的是对话框这个对象；而which：选择了哪一项，就会返回哪一项的
                    public void onClick(DialogInterface dialog, int which) {
                                    index=which;
                    }
                })
                .setPositiveButton("确定", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        text1.setTextSize(textsize[index]);
                        //关闭Dialog对话框
                        dialog.dismiss();

                    }
                })
                .setNegativeButton("取消", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        //关闭Dialog对话框
                        dialog.dismiss();
                    }
                });

        //下面也可以写成：builder.create().show();
        AlertDialog adialog=builder.create();
        adialog.show();

    }


    /*
* 按钮触发方式1：通过按钮的onclick指定点击事件触发的方法名称，方法在activity中进行定义
* */
//    public void method1(View view){
////        btn1.setText("按钮一被点击了");
//
//    }

}

