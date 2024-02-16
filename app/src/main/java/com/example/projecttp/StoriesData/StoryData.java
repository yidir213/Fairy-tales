package com.example.projecttp.StoriesData;

import android.content.Context;
import android.media.MediaPlayer;
import android.transition.Scene;

import com.example.projecttp.Histoire.Scène;
import com.example.projecttp.Histoire.histoire;
import com.example.projecttp.MainActivity3;
import com.example.projecttp.R;

import java.util.ArrayList;

public class StoryData {
    Context context;

    public StoryData(Context context) {
        this.context = context;
    }

    public static ArrayList<histoire> getStories() {
        ArrayList<histoire> stories = new ArrayList<>();

        String s1s1="Once upon a time, there were two best friends, Jack and Emily. They loved exploring new places together and going on adventures. One day, they stumbled upon an old blue castle while walking in the woods. The castle looked ancient and mysterious, and the friends were curious to explore it \n As they approached the castle, they saw a huge gate that led to the entrance. The gate was made of iron and had intricate designs on it. Jack and Emily pushed the gate and walked inside. They were amazed by what they saw. The castle had a huge courtyard with overgrown bushes and trees. In the center of the courtyard, there was a fountain that was not functioning anymore. Jack and Emily looked at each other and knew that this adventure was going to be exciting.";
        String s1s2="As they explored the castle, they stumbled upon a spiral staircase that led up to a tower. Jack and Emily climbed the stairs, and at the top, they found a room with a huge telescope. The telescope was pointing towards the sky, and they could see the stars clearly. They spent some time looking at the stars and imagining different constellations.\n\n\n \n\n \n\n \n\n \n ";
        String s1s3="As they were about to leave, Emily noticed a small door that was hidden behind a bookshelf. They opened the door and found a secret room. The room was filled with old paintings and antique furniture. There was a small table with a map on it. The map had an X-mark on it, and they knew it must be a treasure map. They followed the map's directions and finally found the treasure, which was a chest filled with gold coins./n The friends were overjoyed with their discovery, and they knew that this was their best adventure yet. They took the treasure and decided to split it equally. From that day on, they remained the best of friends and went on many more exciting adventures together. \n \n The END ";
        String s2s1="Once upon a time, there was a boy named Jack who had a beloved dog named Max. They were inseparable and loved to go on adventures together.\n One sunny day, Jack and Max decided to explore the forest near their home. As they walked deeper into the woods, they stumbled upon a clearing with a small stream running through it. Max couldn't resist jumping into the water to cool off, while Jack watched with a smile. Suddenly, they heard a rustling in the bushes. What could it be?\n \n\n";
        String s2s2="Out of the bushes emerged a small, scrappy-looking dog. He looked lost and scared, and Jack knew he had to help. He approached the dog cautiously, and with Max by his side, they managed to gain the dog's trust. They soon discovered that the dog's name was Lucky, and he had run away from his owners. Jack knew they needed to find Lucky's family and bring him back home.\n \n\n \n\n \n";
        String s2s3="With Lucky in tow, Jack and Max set out to find his family. They searched high and low, asking anyone they met if they had seen the missing dog. Finally, they came across a family who recognized Lucky and were overjoyed to be reunited with their beloved pet. Jack and Max were happy to have helped, and they knew they had made a new friend in Lucky.\n \n The END\n \n\n \n\n \n\n ";
        String s3s1="In the forest where Rolly the rabbit and Terry the turtle lived, there was a clearing that served as the perfect race track. Rolly was known to be the fastest animal in the forest, and he loved to show off his speed. Terry, on the other hand, was determined to prove that slow and steady could win the race. \n In the forest where Rolly the rabbit and Terry the turtle lived, there was a clearing that served as the perfect race track. Rolly was known to be the fastest animal in the forest, and he loved to show off his speed. Terry, on the other hand, was determined to prove that slow and steady could win the race.On the day of the big race, all the animals gathered to watch. Rolly was jumping up and down with excitement, while Terry was stretching his legs, getting ready for the race. The other animals cheered them on, and then the signal was given. The race had begun. \n";
        String s3s2="The race began, and Rolly quickly took the lead. He was so far ahead that he decided to take a nap under a tree. Terry continued to plod along, slowly but surely. As the race progressed, Rolly's nap turned into a deep sleep. Terry passed him, moving steadily towards the finish line.\n \n\n \n\n \n\n \n \n\n";
        String s3s3="When Rolly woke up, he realized that Terry was nowhere in sight. He quickly got up and started running towards the finish line. But it was too late. Terry had already won the race. Rolly was disappointed, but he learned an important lesson about overconfidence and the importance of perseverance. \n And so, Terry proved that slow and steady wins the race. From that day on, Rolly and Terry remained friends, but Rolly never underestimated his opponents again. \n \n The END\n \n\n \n\n \n\n";



        ArrayList<Scène> story1Scenes = new ArrayList<>();
        story1Scenes.add(new Scène("The Entrance",R.drawable.im11,s1s1,R.raw.ab));
        story1Scenes.add(new Scène("The Tower", R.drawable.im12,s1s2,R.raw.ab));
        story1Scenes.add(new Scène("The Secret Room", R.drawable.im13,s1s3,R.raw.ab));
        stories.add(new histoire("Jack and Emily", R.drawable.im12, story1Scenes));


        ArrayList<Scène> story2Scenes = new ArrayList<>();
        story2Scenes.add(new Scène("The Forest Adventure", R.drawable.img21,s2s1,R.raw.ab));
        story2Scenes.add(new Scène("The Mysterious Stranger", R.drawable.im22,s2s2,R.raw.ab));
        story2Scenes.add(new Scène("The Happy Reunion", R.drawable.im23,s2s3,R.raw.ab));
        stories.add(new histoire("Friendship", R.drawable.img21, story2Scenes));


        ArrayList<Scène> story3Scenes = new ArrayList<>();
        story3Scenes.add(new Scène("The Forest Adventure",R.drawable.im11,s1s1,R.raw.ab));
        story3Scenes.add(new Scène("The Tower", R.drawable.im12,s1s2,R.raw.ab));
        story3Scenes.add(new Scène("The Secret Room", R.drawable.st5,s1s3,R.raw.ab));
        stories.add(new histoire("Hansel Greetl;", R.drawable.st5, story3Scenes));


        ArrayList<Scène> story4Scenes = new ArrayList<>();
        story4Scenes.add(new Scène("The Race Begins", R.drawable.im31,s3s1,R.raw.ab));
        story4Scenes.add(new Scène("The Race Continues", R.drawable.im32,s3s2,R.raw.ab));
        story4Scenes.add(new Scène("The End of the Race", R.drawable.im33,s3s3,R.raw.ab));
        stories.add(new histoire("The Turtle", R.drawable.im31, story4Scenes));



        return stories;
    }

}
