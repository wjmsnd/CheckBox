package com.example.lee_pc.checkbox;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.CheckBox;
import android.widget.TextView;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by Lee_pc on 2016/11/3.
 */
public class ListViewAdapter extends BaseAdapter {

    String[] s = {"这是一头头猪", "这是一头头鸡", "这是一头头鸭", "这是一头头鱼", "这是一头头狗", "这是一头头大象", "这是一头头老虎", "这是一头头猴子", "这是一头头牲口", "这是一头头饭桶"};

    Context context;


    LinkedList<Boolean> linkedlist = new LinkedList<Boolean>();

    boolean isChecked;
    private TextView title;
    private CheckBox box;

    public ListViewAdapter(Context context) {

        this.context = context;
        for (int i = 0; i < s.length; i++) {
            linkedlist.add(false);
        }

    }

    public List<Boolean> getSelect() {
        return linkedlist;
    }

    @Override
    public int getCount() {
        return s.length;
    }

    @Override
    public Object getItem(int i) {
        return s[i];
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(final int i, View view, ViewGroup viewGroup) {
        view = View.inflate(context, R.layout.list_item, null);

        title = (TextView) view.findViewById(R.id.title);

        box = (CheckBox) view.findViewById(R.id.box);

        title.setText(s[i]);

        box.setChecked(linkedlist.get(i));


        box.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                linkedlist.set(i, !linkedlist.get(i));

                if (linkedlist.contains(false)) {
                    box.setChecked(false);
                } else {
                    box.setChecked(true);
                }
                notifyDataSetChanged();
            }
        });


        return view;
    }
}
