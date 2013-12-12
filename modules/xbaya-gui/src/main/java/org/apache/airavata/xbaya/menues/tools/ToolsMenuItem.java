/*
 *
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied.  See the License for the
 * specific language governing permissions and limitations
 * under the License.
 *
 */

package org.apache.airavata.xbaya.menues.tools;

import org.apache.airavata.xbaya.XBayaEngine;
import org.apache.airavata.xbaya.ui.dialogs.GlobusFileTransferWindow;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;

public class ToolsMenuItem {

    private XBayaEngine engine;

    private JMenu toolsMenu;

    private static final Logger logger = LoggerFactory.getLogger(ToolsMenuItem.class);

    /**
     * Constructs a WorkflowMenu.
     * 
     * @param engine
     */
    public ToolsMenuItem(XBayaEngine engine) {
        this.engine = engine;
        createWorkflowMenu();
    }

    /**
     * @return The workflow menu.
     */
    public JMenu getMenu() {
        return this.toolsMenu;
    }

    /**
     * Creates workflow menu.
     */
    private void createWorkflowMenu() {
        JMenuItem globusFileTransferItem = createGlobusFileTransferItem();
        toolsMenu = new JMenu("Tools");
        toolsMenu.setMnemonic(KeyEvent.VK_T);
        toolsMenu.add(globusFileTransferItem);

    }
    
    private JMenuItem createGlobusFileTransferItem() {
        JMenuItem item = new JMenuItem("Globus File Transfer...");
        item.setMnemonic(KeyEvent.VK_J);
        item.addActionListener(new AbstractAction() {
            private GlobusFileTransferWindow window;

            public void actionPerformed(ActionEvent e) {
                if (this.window == null) {
                    this.window = new GlobusFileTransferWindow(engine);
                }
                this.window.show();
            }
        });
        return item;
    }

//    private JMenuItem createAmberRunItem() {
//        JMenuItem item = new JMenuItem("Amber Run...");
//        item.setMnemonic(KeyEvent.VK_J);
//        item.addActionListener(new AbstractAction() {
//            private AmberRunWindow window;
//
//            public void actionPerformed(ActionEvent e) {
//                if (this.window == null) {
//                    this.window = new AmberRunWindow(engine);
//                }
//                this.window.show();
//            }
//        });
//        return item;
//    }
}