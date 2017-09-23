/*
Copyleft (C) 2005 H�lio Perroni Filho
xperroni@yahoo.com
ICQ: 2490863

This file is part of ChatterBean.

ChatterBean is free software; you can redistribute it and/or modify it under the terms of the GNU General Public License as published by the Free Software Foundation; either version 2 of the License, or (at your option) any later version.

ChatterBean is distributed in the hope that it will be useful, but WITHOUT ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the GNU General Public License for more details.

You should have received a copy of the GNU General Public License along with ChatterBean (look at the Documents/ directory); if not, either write to the Free Software Foundation, Inc., 59 Temple Place, Suite 330, Boston, MA  02111-1307 USA, or visit (http://www.gnu.org/licenses/gpl.txt).
*/

package bitoflife.chatterbean;

import java.io.FileInputStream;
import java.io.InputStream;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.PrintStream;
import java.net.URL;
import java.net.URLClassLoader;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;

import bitoflife.chatterbean.parser.AliceBotParser;
import bitoflife.chatterbean.util.Searcher;

public class AliceBotMother
{
  /*
  Attribute Section
  */

  private ByteArrayOutputStream gossip;
  
  /*
  Event Section
  */
  
  public void setUp()
  {
    gossip = new ByteArrayOutputStream();
  }
  
  /*
  Method Section
  */
  
  public String gossip()
  {
    return gossip.toString();
  }

  public AliceBot newInstance() throws Exception
  {
    Searcher searcher = new Searcher();
    AliceBotParser parser = new AliceBotParser();
/*    InputStream is = this.getClass().getClassLoader().getResourceAsStream("Bots/context.xml");
    System.out.println(is.read());
*/
    /*File folder = new File(url.toURI());
    File[] listOfFiles = folder.listFiles();

        for (int i = 0; i < listOfFiles.length; i++) {
          if (listOfFiles[i].isFile()) {
            System.out.println("File " + listOfFiles[i].getName());
          } else if (listOfFiles[i].isDirectory()) {
            System.out.println("Directory " + listOfFiles[i].getName());
          }
        }*/
    Resource resource1 = new ClassPathResource("Bots/context.xml");
    InputStream inputStream1 = resource1.getInputStream();
    Path ctx = Files.createTempFile("context", ".xml");
    Files.copy(inputStream1, ctx, StandardCopyOption.REPLACE_EXISTING);
    
    Resource resource2 = new ClassPathResource("Bots/splitters.xml");
    InputStream inputStream2 = resource2.getInputStream();
    Path splitters = Files.createTempFile("splitters", ".xml");
    Files.copy(inputStream2, splitters, StandardCopyOption.REPLACE_EXISTING);
    
    Resource resource3 = new ClassPathResource("Bots/substitutions.xml");
    InputStream inputStream3 = resource3.getInputStream();
    Path substitutions = Files.createTempFile("substitutions", ".xml");
    Files.copy(inputStream3, substitutions, StandardCopyOption.REPLACE_EXISTING);
    
    Resource resource5 = new ClassPathResource("Bots/mainFile.aiml");
    InputStream inputStream5 = resource5.getInputStream();
    Path mainFile = Files.createTempFile("mainFile", ".aiml");
    Files.copy(inputStream5, mainFile, StandardCopyOption.REPLACE_EXISTING);
    
/*    Resource resource4 = new ClassPathResource("Bots/Alice");
    InputStream inputStream4 = resource4.getInputStream();
    Path alice = Files.createTempDirectory("alice");
    Files.copy(inputStream4, alice, StandardCopyOption.REPLACE_EXISTING);*/
System.out.println("files mil gyi");
    AliceBot bot = parser.parse(new FileInputStream(ctx.toFile()),
    							new FileInputStream(splitters.toFile()),
    							new FileInputStream(substitutions.toFile()),
    							new FileInputStream(mainFile.toFile()));
    							//searcher.search("Bots/Alice", ".*\\.aiml"));
System.out.println("fdsf");
    Context context = bot.getContext(); 
    context.outputStream(gossip);
    return bot;
  }
}
