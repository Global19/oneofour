/*******************************************************************************
 * Copyright (c) 2014 IBH SYSTEMS GmbH and others.
 * 
 * This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v2.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v20.html
 * 
 * SPDX-License-Identifier: EPL-2.0
 *
 * Contributors:
 *     IBH SYSTEMS GmbH - initial API and implementation
 *******************************************************************************/
package org.eclipse.oneofour.asdu;

import org.eclipse.oneofour.asdu.types.ASDUAddress;
import org.eclipse.oneofour.asdu.types.Cause;
import org.eclipse.oneofour.asdu.types.CauseOfTransmission;

public class ASDUHeader
{
    private final CauseOfTransmission causeOfTransmission;

    private final ASDUAddress asduAddress;

    public ASDUHeader ( final CauseOfTransmission causeOfTransmission, final ASDUAddress asduAddress )
    {
        this.causeOfTransmission = causeOfTransmission;
        this.asduAddress = asduAddress;
    }

    public CauseOfTransmission getCauseOfTransmission ()
    {
        return this.causeOfTransmission;
    }

    public ASDUAddress getAsduAddress ()
    {
        return this.asduAddress;
    }

    @Override
    public String toString ()
    {
        return String.format ( "[cause: %s, address: %s]", this.causeOfTransmission, this.asduAddress );
    }

    public ASDUHeader clone ( final CauseOfTransmission causeOfTransmission )
    {
        return new ASDUHeader ( causeOfTransmission, this.asduAddress );
    }

    public ASDUHeader clone ( final Cause cause )
    {
        return new ASDUHeader ( new CauseOfTransmission ( cause, this.causeOfTransmission.getSourceAddress () ), this.asduAddress );
    }

    public ASDUHeader clone ( final Cause cause, final boolean positive )
    {
        return new ASDUHeader ( new CauseOfTransmission ( cause, this.causeOfTransmission.getSourceAddress (), positive, false ), this.asduAddress );
    }

    @Override
    public int hashCode ()
    {
        final int prime = 31;
        int result = 1;
        result = prime * result + ( this.asduAddress == null ? 0 : this.asduAddress.hashCode () );
        result = prime * result + ( this.causeOfTransmission == null ? 0 : this.causeOfTransmission.hashCode () );
        return result;
    }

    @Override
    public boolean equals ( final Object obj )
    {
        if ( this == obj )
        {
            return true;
        }
        if ( obj == null )
        {
            return false;
        }
        if ( getClass () != obj.getClass () )
        {
            return false;
        }
        final ASDUHeader other = (ASDUHeader)obj;
        if ( this.asduAddress == null )
        {
            if ( other.asduAddress != null )
            {
                return false;
            }
        }
        else if ( !this.asduAddress.equals ( other.asduAddress ) )
        {
            return false;
        }
        if ( this.causeOfTransmission == null )
        {
            if ( other.causeOfTransmission != null )
            {
                return false;
            }
        }
        else if ( !this.causeOfTransmission.equals ( other.causeOfTransmission ) )
        {
            return false;
        }
        return true;
    }

}
