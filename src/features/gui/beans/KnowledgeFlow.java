/*
 *    This program is free software; you can redistribute it and/or modify
 *    it under the terms of the GNU General Public License as published by
 *    the Free Software Foundation; either version 2 of the License, or
 *    (at your option) any later version.
 *
 *    This program is distributed in the hope that it will be useful,
 *    but WITHOUT ANY WARRANTY; without even the implied warranty of
 *    MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 *    GNU General Public License for more details.
 *
 *    You should have received a copy of the GNU General Public License
 *    along with this program; if not, write to the Free Software
 *    Foundation, Inc., 675 Mass Ave, Cambridge, MA 02139, USA.
 */

/*
 *    KnowledgeFlow.java
 *    Copyright (C) 2005 University of Waikato, Hamilton, New Zealand
 *
 */

package features.gui.beans;

/**
 * Startup class for the KnowledgeFlow. Displays a splash screen.
 *
 * @author Mark Hall
 * @version  $Revision: 7059 $
 */
public class KnowledgeFlow {

  /**
   * Static method that can be called from a running program
   * to launch the KnowledgeFlow
   */
  public static void startApp() {
    KnowledgeFlowApp.addStartupListener(new StartUpListener() {
        public void startUpComplete() {
          features.gui.SplashWindow.disposeSplash();
        }
      });
                                        
    features.gui.SplashWindow.splash(ClassLoader.
                                 getSystemResource("features/gui/beans/icons/splash.jpg"));

    Thread nt = new Thread() {
        public void run() {
          features.gui.SplashWindow.invokeMethod("features.gui.beans.KnowledgeFlowApp", 
                                             "createSingleton", null);
        }};
      nt.start();
  }

    /**
     * Shows the splash screen, launches the application and then disposes
     * the splash screen.
     * @param args the command line arguments
     */
    public static void main(String[] args) {
      features.core.logging.Logger.log(features.core.logging.Logger.Level.INFO, Messages.getInstance().getString("KnowledgeFlow_Main_Logger_Text"));
      features.gui.SplashWindow.splash(ClassLoader.
                                   getSystemResource("features/gui/beans/icons/splash.jpg"));
      features.gui.SplashWindow.invokeMain("features.gui.beans.KnowledgeFlowApp", args);
      features.gui.SplashWindow.disposeSplash();
    }
  
}
