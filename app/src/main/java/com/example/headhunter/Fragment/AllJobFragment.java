package com.example.headhunter.Fragment;


import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.headhunter.Activity.JobDetailsActivity;
import com.example.headhunter.Adapter.AllJobAdapter;
import com.example.headhunter.Model.Data;
import com.example.headhunter.R;

import java.util.ArrayList;
import java.util.List;

public class AllJobFragment extends Fragment {

    public AllJobFragment() {}

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_all_job, container, false);
        RecyclerView recyclerView = view.findViewById(R.id.recycler_posted_all_job);

        List<Data> initialDataList = new ArrayList<>();

        Data data1 = new Data(
                "Software Engineer",
                "ABC Company, a leading tech company, is seeking a skilled software engineer to join our growing team. As a part of our engineering department, you will work on developing and optimizing our cutting-edge software products. We're looking for candidates with a strong background in Java, C++, and Android development. Your role will involve working closely with our product and design teams to create seamless, efficient, and innovative software solutions. Ideal candidates will have experience with software development cycles, a commitment to quality code, and a passion for technology and continuous learning.",
                "Java, C++, Android",
                "$80,000 - $100,000",
                "1",
                "2022-02-19",
                "ABC@gmail.com",
                "ABC Company",
                "info@abc.com",
                "At ABC Company, we're driving innovation in the tech industry with our software solutions. Our team is dedicated to excellence, creativity, and pushing the boundaries of technology. We offer a dynamic work environment where you can grow your skills and make a significant impact. Join us to be at the forefront of technological advancement.",
                "123 Main St, City",
                R.drawable.abc);
        Data data2 = new Data(
                "Graphic Designer",
                "Join our creative team at XYZ Design Studio as a graphic designer to bring innovative concepts to life. We're looking for a passionate individual with a keen eye for design and a strong proficiency in Adobe Photoshop and Illustrator. In this role, you will collaborate with our dynamic team to create compelling visuals for our clients across various industries. Responsibilities include crafting graphic elements, developing brand identities, and producing digital and print materials. If you have a portfolio that showcases your creativity and a desire to push boundaries, we’d love to hear from you.",
                "Adobe Photoshop, Illustrator",
                "$60,000 - $80,000",
                "2",
                "2022-02-20",
                "designer@example.com",
                "XYZ Design Studio",
                "hr@xyzdesign.com",
                "Innovative design studio with a commitment to crafting visually stunning and effective designs. At XYZ Design Studio, we believe in the power of creativity to transform brands and engage audiences. Join us to be a part of a team that values innovation, excellence, and collaborative spirit.",
                "456 Design Ave, Town",
                R.drawable.xyz);

        Data data5 = new Data(
                "Mobile App Developer",
                "Kaspi.kz is seeking a talented mobile app developer with experience in Flutter or React Native to join our dynamic team. As a part of our mobile development team, you'll play a key role in building and enhancing our award-winning mobile app. We're looking for individuals passionate about creating seamless user experiences and willing to push boundaries.",
                "Flutter, React Native, UI/UX Design",
                "$50,000 - $80,000",
                "5",
                "2022-04-05",
                "apps@kaspi.kz",
                "Kaspi.kz",
                "hr@kaspi.kz",
                "Kaspi.kz is a leading fintech platform in Kazakhstan, offering a wide range of financial services and technology solutions to simplify the financial lives of its customers. With a focus on innovation and excellence, Kaspi.kz continues to redefine the banking experience in Central Asia.",
                "Nur-Sultan, Kazakhstan",
                R.drawable.kaspi);
        Data data6 = new Data(
                "Digital Marketing Specialist",
                "Koles.kz is looking for an experienced Digital Marketing Specialist to join our team. In this role, you will be responsible for planning, implementing, and monitoring our digital marketing campaigns across all digital networks. Our ideal candidate is someone with experience in marketing, art direction, and social media management, who can enhance our brand and build strong online communities through our various social media platforms.",
                "SEO, SEM, PPC, Social Media, Content Marketing, Analytics",
                "$40,000 - $70,000",
                "6",
                "2022-05-10",
                "marketing@koles.kz",
                "Koles.kz",
                "careers@koles.kz",
                "Koles.kz is a leading tire and auto accessories seller in Kazakhstan, known for our wide selection of products and exceptional customer service. We're dedicated to driving forward the automotive industry in Kazakhstan by offering quality products and informative content to our customers.",
                "Almaty, Kazakhstan",
                R.drawable.kolesapng);
        Data data7 = new Data(
                "Travel Consultant",
                "Aviata.kz is seeking an experienced Travel Consultant to join our vibrant team. You will be responsible for crafting custom travel itineraries, providing exceptional customer service, and utilizing your knowledge of the travel industry to ensure our clients have the best travel experience. Ideal candidates will have a passion for travel, strong communication skills, and experience with travel booking systems.",
                "Customer Service, Sales, Travel Planning, GDS Systems, Communication",
                "$30,000 - $50,000",
                "7",
                "2024-01-15",
                "hr@aviata.kz",
                "Aviata.kz",
                "careers@aviata.kz",
                "Aviata.kz is a leading online platform for purchasing airline tickets in Kazakhstan, offering a fast, convenient, and secure way to book flights to destinations worldwide. We are committed to providing our customers with comprehensive travel solutions and exceptional service.",
                "Nur-Sultan, Kazakhstan",
                R.drawable.aviatajpg
        );
        // Sample Data 7
        Data data8 = new Data(
                "iOS Developer",
                "iPhone Apps Innovations is seeking a skilled iOS Developer to join our dynamic team. You will be responsible for the development and maintenance of applications aimed at a range of iOS devices, including mobile phones and tablet computers. Your primary focus will be the development of iOS applications and their integration with back-end services. You will be working alongside other engineers and developers working on different layers of the infrastructure.",
                "Swift, Objective-C, iOS SDK, Xcode, UI/UX Design",
                "$80,000 - $120,000",
                "7",
                "2022-06-15",
                "devs@iphoneapps.com",
                "iPhone Apps Innovations",
                "careers@iphoneapps.com",
                "iPhone Apps Innovations is at the forefront of mobile technology, dedicated to creating innovative and user-friendly applications for iPhone users around the world. We believe in pushing the boundaries of what's possible on iOS platforms to provide the best experiences for our customers.",
                "Silicon Valley, USA",
                R.drawable.apple2);

        initialDataList.add(data1);
        initialDataList.add(data2);
        initialDataList.add(data5);
        initialDataList.add(data6);
        initialDataList.add(data7);
        initialDataList.add(data8);

        AllJobAdapter adapter = new AllJobAdapter(initialDataList);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        recyclerView.setHasFixedSize(true);

        adapter.setOnItemClickListener(data -> {
            Intent intent = new Intent(getActivity(), JobDetailsActivity.class);
            // Передайте все необходимые данные через intent
            intent.putExtra("title", data.getTitle());
            intent.putExtra("date", data.getDate());
            intent.putExtra("description", data.getDescription());
            intent.putExtra("skills", data.getSkills());
            intent.putExtra("salary", data.getSalary());
            intent.putExtra("email", data.getEmail());
            intent.putExtra("companyName", data.getCompanyName());
            intent.putExtra("companyEmail", data.getCompanyEmail());
            intent.putExtra("companyAddress", data.getCompanyAddress());
            intent.putExtra("aboutCompany", data.getAboutCompany());
            startActivity(intent);
        });
        return view;
    }
}
