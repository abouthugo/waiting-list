package info.androidhive.sqlite.view;

/**
 * Created by ravi on 20/02/18.
 */

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import info.androidhive.sqlite.R;
import info.androidhive.sqlite.database.model.Student;
import java.util.List;

public class StudentAdapter extends RecyclerView.Adapter<StudentAdapter.MyViewHolder> {

    private Context context;
    private List<Student> studentsList;

    public class MyViewHolder extends RecyclerView.ViewHolder {
        public TextView course;
        public TextView studentName;
        public TextView grade;

        public MyViewHolder(View view) {
            super(view);
            course = view.findViewById(R.id.student_course);
            studentName = view.findViewById(R.id.student_dot);
            grade = view.findViewById(R.id.grade);
        }
    }


    public StudentAdapter(Context context, List<Student> studentsList) {
        this.context = context;
        this.studentsList = studentsList;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.list_row, parent, false);

        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        Student student = studentsList.get(position);

        holder.course.setText(student.getCourse());

        // Displaying studentName from HTML character code
        holder.studentName.setText(student.getName());

        // Displaying grade
        holder.grade.setText(Integer.toString(student.getGrade()));
    }

    @Override
    public int getItemCount() {
        return studentsList.size();
    }

}
