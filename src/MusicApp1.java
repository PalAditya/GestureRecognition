import javax.sound.midi.*;
public class MusicApp1
{
    public static void main(String args[])
    {
        MusicApp1 obj=new MusicApp1();
        obj.play();   
    }
    public void play()
    {
        try
        {
            {
                Sequencer box=MidiSystem.getSequencer();
                box.open();
                Sequence s=new Sequence(Sequence.PPQ,4);
                Track t=s.createTrack();
                ShortMessage a=new ShortMessage();
                a.setMessage(144, 1, 40, 100);
                MidiEvent noteOn=new MidiEvent(a,1);
                t.add(noteOn);
                ShortMessage b=new ShortMessage();
                b.setMessage(128, 1, 30, 100);
                MidiEvent noteOff=new MidiEvent(b,16);
                t.add(noteOff);
                box.setSequence(s);
                box.start();
            }
        }catch(Exception e)
                {
                    e.printStackTrace();
                }
    }
}