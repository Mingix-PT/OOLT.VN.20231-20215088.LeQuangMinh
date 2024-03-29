package hust.soict.hedspi.aims.media;

import hust.soict.hedspi.aims.exception.PlayerException;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;

public class CompactDisc extends Disc implements Playable{
    private String artist;
    private List<Track> trackList = new ArrayList<Track>();

    private static int nbCompactDiscs = 0;

    public CompactDisc(String title) {
        super(title);
    }

    public CompactDisc(String title, String category) {
        super(title, category);
    }

    public CompactDisc(String title, String category, float cost) {
        super(title, category, cost);
    }

    public CompactDisc(String title, String category, String director, float cost) {
        super(title, category, cost);
        this.director = director;
    }

    public CompactDisc(String title, String category, String director, int length, float cost) {
        super(title, category, director, length, cost);
    }
    public CompactDisc(String title, String category, String artist, String director, float cost) {
        super(title, category, director, cost);
        this.artist = artist;
    }

    public CompactDisc(String title, String category, String artist, String director, int length, float cost) {
        super(title, category, director, length, cost);
        this.artist = artist;
    }

    public String getArtist() {
        return artist;
    }

    public void addTrack(Track track) {
        if (nbCompactDiscs < 100) {
            if (!trackList.contains(track)) {
                trackList.add(track);
                nbCompactDiscs++;
            }
            else {
                System.out.println("The track " + track.getTitle() + " is already in the list");
            }
        } else {
            System.out.println("The track list is full");
        }
    }

    public void addTracks(List<Track> tracks) {
        for (Track track : tracks) {
            addTrack(track);
        }
    }

    public void removeTrack(Track track) {
        if (trackList.contains(track)) {
            trackList.remove(track);
            nbCompactDiscs--;
        }
        else {
            System.out.println("The track " + track.getTitle() + " is not in the list");
        }
    }

    public int getLength() {
        int length = 0;
        for (Track track : trackList) {
            length += track.getLength();
        }
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }

    public int getTrackNumber() {
        return trackList.size();
    }

    public List<Track> getTrackList() {
        return trackList;
    }

    @Override
    public void play() throws PlayerException {
        if (this.getLength() <= 0) {
            throw new PlayerException("ERROR: CD length is non-positive!");
        }
        else {
            System.out.println("Playing CD: " + this.getTitle());
            System.out.println("CD length: " + this.getLength());
            for (Track track : trackList) {
                try {
                    track.play();
                } catch (PlayerException e) {
                    throw e;
                }
            }
        }
    }

    @Override
    public String playMessage() throws PlayerException {
        if (this.getLength() <= 0) {
            throw new PlayerException("ERROR: CD length is non-positive!");
        }
        else {
            StringBuilder message = new StringBuilder("Playing CD: " + this.getTitle() + "\nCD length: " + this.getLength());
            for (Track track : trackList) {
                message.append("\n").append(track.playMessage());
            }
            return message.toString();
        }
    }

    @Override
    public void playOptionPane() throws PlayerException {
        if (this.getLength() <= 0) {
            throw new PlayerException("ERROR: CD length is non-positive!");
        }
        else {
            JOptionPane.showMessageDialog(null, this.playMessage());
        }
    }

    public String toString() {
        return "CD - " + super.getTitle() + " - " + super.getCategory() + " - " + this.getArtist() + " - " +
                super.getDirector() + " - " + super.getLength() + " : " + super.getCost() + "$";
    }
}
