/*******************************************************************************
 * Copyright (c) 2006, 2013 TH4 SYSTEMS GmbH and others.
 * 
 * This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v2.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v20.html
 * 
 * SPDX-License-Identifier: EPL-2.0
 *
 * Contributors:
 *     TH4 SYSTEMS GmbH - initial API and implementation
 *     Jens Reimann - further development
 *******************************************************************************/
package org.eclipse.oneofour.utils.concurrent;

import java.util.concurrent.Executor;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * An executor which directly calls the runnable
 *
 * @author Jens Reimann
 */
public class DirectExecutor implements Executor
{

    private final static Logger logger = LoggerFactory.getLogger ( DirectExecutor.class );

    public static Executor INSTANCE = new DirectExecutor ();

    @Override
    public void execute ( final Runnable command )
    {
        try
        {
            command.run ();
        }
        catch ( final Exception e )
        {
            logger.info ( "Failed to process", e );
        }
    }

}
