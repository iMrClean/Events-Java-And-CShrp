using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace CEvents
{
    class Program
    {
        static void Main(string[] args)
        {
            Metronome m = new Metronome();
            m.Tick += Time;
            m.Start();
        }

        private static void Time()
        {
            System.Console.WriteLine("Time now: " + DateTime.Now);
        }
    }

    class Metronome
    {
        public event TickHandler Tick;
        public delegate void TickHandler();

        public void Start()
        {
            while (true)
            {
                System.Threading.Thread.Sleep(1000);
                Tick?.Invoke();
            }
        }
    }
}
