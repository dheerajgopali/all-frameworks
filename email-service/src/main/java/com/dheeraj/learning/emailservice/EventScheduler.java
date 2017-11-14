package com.dheeraj.learning.emailservice;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Date;
import java.util.Properties;
import java.util.Timer;
import java.util.TimerTask;

/**
 * Created by gopad on 28-09-2017.
 */
public class EventScheduler {
    private static EmailServerData esd = new EmailServerData();
    private static EmailData ed = new EmailData();
    private static SystemData sd = new SystemData();
    private static Properties prop = new Properties();

    public static void main(String[] args) {
        setProps();
        //schedule();
        checkAndSendEmail();
    }

    public static void setProps(){
        try {
            File file = new File("email-service\\src\\main\\resources\\Config.properties");
            System.out.println(file.getAbsolutePath());
            System.out.println("Reading config file : "+file.getAbsolutePath()+" ...");
            prop.load(new FileInputStream(file));
        } catch (IOException e) {
            e.printStackTrace();
        }


        //Set props
        ed.setTo(prop.getProperty("email.to","DheerajKumar.Gopali@in.pega.com"));
        ed.setFrom(prop.getProperty("email.from","DheerajKumar.Gopali@in.pega.com"));
        ed.setSubject(prop.getProperty("email.subject","Low disk space Alert!!!!!!"));

        esd.setSmtpHostKey(prop.getProperty("host.key","mail.smtp.host"));
        esd.setSmtpHostValue(prop.getProperty("host.value","EXINTOPEN.rpega.com"));

        sd.setSystemName(prop.getProperty("system.name","WBBPERF1W7"));
        sd.setDiskSpaceToCheck(prop.getProperty("drive.to.check","C:"));
        sd.setMinDiskSpace(Integer.parseInt(prop.getProperty("min.disk.space","200")));
        sd.setFrequencyStringFormat(prop.getProperty("frequency.to.check","60*1000"));
        sd.setFrequency(convertFrequency(sd.getFrequencyStringFormat()));
    }

    public static long convertFrequency(String str){
        String[] strings = str.split("\\*");
        long temp=1;
        for (int i = 0; i < strings.length; i++) {
            temp*=Long.parseLong(strings[i]);
        }
        return temp;
    }

    public static void checkAndSendEmail() {
        File f = new File(sd.getDiskSpaceToCheck());
        sd.setTotalSpace(inGB(f.getTotalSpace()));
        sd.setFreeSpace(inGB(f.getFreeSpace()));

        System.out.println("Total space : "+sd.getTotalSpace()+ " GB");
        System.out.println("Free space : "+sd.getFreeSpace()+ " GB");

        if(sd.getFreeSpace() < sd.getMinDiskSpace()){
            setText();
            //EmailService.sendEmail(esd,ed);
        }
    }
    public static long inGB(long space){
        return space/(1024*1024*1024);
    }

    public static void schedule() {
        Date date=new Date();
        Timer timer = new Timer();

        timer.schedule(new TimerTask(){
            public void run(){
                checkAndSendEmail();
            }
        },date, sd.getFrequency());//24*60*60*1000 add 24 hours delay between job executions.
    }

    public static void setText(){
        ed.setText("<html xmlns:v=\"urn:schemas-microsoft-com:vml\" xmlns:o=\"urn:schemas-microsoft-com:office:office\" xmlns:w=\"urn:schemas-microsoft-com:office:word\" xmlns:m=\"http://schemas.microsoft.com/office/2004/12/omml\" xmlns=\"http://www.w3.org/TR/REC-html40\">\n" +
                "   <head>\n" +
                "      <meta http-equiv=Content-Type content=\"text/html; charset=us-ascii\">\n" +
                "      <meta name=Generator content=\"Microsoft Word 15 (filtered medium)\">\n" +
                "      <style>\n" +
                "         <!--\n" +
                "            /* Font Definitions */\n" +
                "            @font-face\n" +
                "            \t{font-family:\"Cambria Math\";\n" +
                "            \tpanose-1:2 4 5 3 5 4 6 3 2 4;}\n" +
                "            @font-face\n" +
                "            \t{font-family:Calibri;\n" +
                "            \tpanose-1:2 15 5 2 2 2 4 3 2 4;}\n" +
                "            /* Style Definitions */\n" +
                "            p.MsoNormal, li.MsoNormal, div.MsoNormal\n" +
                "            \t{margin:0cm;\n" +
                "            \tmargin-bottom:.0001pt;\n" +
                "            \tfont-size:11.0pt;\n" +
                "            \tfont-family:\"Calibri\",sans-serif;\n" +
                "            \tmso-fareast-language:EN-US;}\n" +
                "            a:link, span.MsoHyperlink\n" +
                "            \t{mso-style-priority:99;\n" +
                "            \tcolor:#0563C1;\n" +
                "            \ttext-decoration:underline;}\n" +
                "            a:visited, span.MsoHyperlinkFollowed\n" +
                "            \t{mso-style-priority:99;\n" +
                "            \tcolor:#954F72;\n" +
                "            \ttext-decoration:underline;}\n" +
                "            span.EmailStyle17\n" +
                "            \t{mso-style-type:personal-compose;\n" +
                "            \tfont-family:\"Calibri\",sans-serif;\n" +
                "            \tcolor:windowtext;}\n" +
                "            .MsoChpDefault\n" +
                "            \t{mso-style-type:export-only;\n" +
                "            \tfont-family:\"Calibri\",sans-serif;\n" +
                "            \tmso-fareast-language:EN-US;}\n" +
                "            @page WordSection1\n" +
                "            \t{size:612.0pt 792.0pt;\n" +
                "            \tmargin:72.0pt 72.0pt 72.0pt 72.0pt;}\n" +
                "            div.WordSection1\n" +
                "            \t{page:WordSection1;}\n" +
                "            -->\n" +
                "      </style>\n" +
                "      <!--[if gte mso 9]>\n" +
                "      <xml>\n" +
                "         <o:shapedefaults v:ext=\"edit\" spidmax=\"1026\" />\n" +
                "      </xml>\n" +
                "      <![endif]--><!--[if gte mso 9]>\n" +
                "      <xml>\n" +
                "         <o:shapelayout v:ext=\"edit\">\n" +
                "            <o:idmap v:ext=\"edit\" data=\"1\" />\n" +
                "         </o:shapelayout>\n" +
                "      </xml>\n" +
                "      <![endif]-->\n" +
                "   </head>\n" +
                "   <body lang=EN-IN link=\"#0563C1\" vlink=\"#954F72\">\n" +
                "      <div class=WordSection1>\n" +
                "         <p class=MsoNormal>\n" +
                "            Hi All\n" +
                "            <o:p></o:p>\n" +
                "         </p>\n" +
                "         <p class=MsoNormal>\n" +
                "            <o:p>&nbsp;</o:p>\n" +
                "         </p>\n" +
                "         <p class=MsoNormal>\n" +
                "            This is an auto generated email triggered due to low disk space in "+sd.getSystemName()+". \n" +
                "            <o:p></o:p>\n" +
                "         </p>\n" +
                "         <p class=MsoNormal>\n" +
                "            <o:p>&nbsp;</o:p>\n" +
                "         </p>\n" +
                "         <table class=MsoTable15Grid4Accent2 border=1 cellspacing=0 cellpadding=0 style='border-collapse:collapse;border:none'>\n" +
                "            <tr>\n" +
                "               <td width=195 valign=top style='width:116.85pt;border:solid #ED7D31 1.0pt;border-right:none;background:#ED7D31;padding:0cm 5.4pt 0cm 5.4pt'>\n" +
                "                  <p class=MsoNormal>\n" +
                "                     <b>\n" +
                "                        <span style='color:white'>\n" +
                "                           System Name\n" +
                "                           <o:p></o:p>\n" +
                "                        </span>\n" +
                "                     </b>\n" +
                "                  </p>\n" +
                "               </td>\n" +
                "               <td width=195 valign=top style='width:116.85pt;border-top:solid #ED7D31 1.0pt;border-left:none;border-bottom:solid #ED7D31 1.0pt;border-right:none;background:#ED7D31;padding:0cm 5.4pt 0cm 5.4pt'>\n" +
                "                  <p class=MsoNormal>\n" +
                "                     <b>\n" +
                "                        <span style='color:white'>\n" +
                "                           Drive\n" +
                "                           <o:p></o:p>\n" +
                "                        </span>\n" +
                "                     </b>\n" +
                "                  </p>\n" +
                "               </td>\n" +
                "               <td width=195 valign=top style='width:116.9pt;border-top:solid #ED7D31 1.0pt;border-left:none;border-bottom:solid #ED7D31 1.0pt;border-right:none;background:#ED7D31;padding:0cm 5.4pt 0cm 5.4pt'>\n" +
                "                  <p class=MsoNormal>\n" +
                "                     <b>\n" +
                "                        <span style='color:white'>\n" +
                "                           Total space\n" +
                "                           <o:p></o:p>\n" +
                "                        </span>\n" +
                "                     </b>\n" +
                "                  </p>\n" +
                "               </td>\n" +
                "               <td width=195 valign=top style='width:116.9pt;border:solid #ED7D31 1.0pt;border-left:none;background:#ED7D31;padding:0cm 5.4pt 0cm 5.4pt'>\n" +
                "                  <p class=MsoNormal>\n" +
                "                     <b>\n" +
                "                        <span style='color:white'>\n" +
                "                           Free Space\n" +
                "                           <o:p></o:p>\n" +
                "                        </span>\n" +
                "                     </b>\n" +
                "                  </p>\n" +
                "               </td>\n" +
                "            </tr>\n" +
                "            <tr>\n" +
                "               <td width=195 valign=top style='width:116.85pt;border:solid #F4B083 1.0pt;border-top:none;background:#FBE4D5;padding:0cm 5.4pt 0cm 5.4pt'>\n" +
                "                  <p class=MsoNormal>\n" +
                "                     <b>\n" +
                sd.getSystemName() +
                "                        <o:p></o:p>\n" +
                "                     </b>\n" +
                "                  </p>\n" +
                "               </td>\n" +
                "               <td width=195 valign=top style='width:116.85pt;border-top:none;border-left:none;border-bottom:solid #F4B083 1.0pt;border-right:solid #F4B083 1.0pt;background:#FBE4D5;padding:0cm 5.4pt 0cm 5.4pt'>\n" +
                "                  <p class=MsoNormal>\n" +
                sd.getDiskSpaceToCheck() +
                "                     <o:p></o:p>\n" +
                "                  </p>\n" +
                "               </td>\n" +
                "               <td width=195 valign=top style='width:116.9pt;border-top:none;border-left:none;border-bottom:solid #F4B083 1.0pt;border-right:solid #F4B083 1.0pt;background:#FBE4D5;padding:0cm 5.4pt 0cm 5.4pt'>\n" +
                "                  <p class=MsoNormal>\n" +
                sd.getTotalSpace() + " GB" +
                "                     <o:p></o:p>\n" +
                "                  </p>\n" +
                "               </td>\n" +
                "               <td width=195 valign=top style='width:116.9pt;border-top:none;border-left:none;border-bottom:solid #F4B083 1.0pt;border-right:solid #F4B083 1.0pt;background:#FBE4D5;padding:0cm 5.4pt 0cm 5.4pt'>\n" +
                "                  <p class=MsoNormal>\n" +
                sd.getFreeSpace() + " GB" +
                "                     <o:p></o:p>\n" +
                "                  </p>\n" +
                "               </td>\n" +
                "            </tr>\n" +
                "         </table>\n" +
                "         <p class=MsoNormal>\n" +
                "            <o:p>&nbsp;</o:p>\n" +
                "         </p>\n" +
                "         <p class=MsoNormal>\n" +
                "            <b>\n" +
                "               Please free up the space in "+sd.getDiskSpaceToCheck()+" drive. \n" +
                "               <span style='color:red'>\n" +
                "                  Otherwise new database dumps won&#8217;t be generated.\n" +
                "                  <o:p></o:p>\n" +
                "               </span>\n" +
                "            </b>\n" +
                "         </p>\n" +
                "         <p class=MsoNormal>\n" +
                "            <o:p>&nbsp;</o:p>\n" +
                "         </p>\n" +
                "         <p class=MsoNormal>\n" +
                "            Thanks\n" +
                "            <o:p></o:p>\n" +
                "         </p>\n" +
                "         <p class=MsoNormal>\n" +
                "            Dheeraj\n" +
                "            <o:p></o:p>\n" +
                "         </p>\n" +
                "      </div>\n" +
                "   </body>\n" +
                "</html>");
    }
}
