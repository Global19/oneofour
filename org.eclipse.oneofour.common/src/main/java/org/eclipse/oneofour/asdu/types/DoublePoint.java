/*******************************************************************************
 * Copyright (c) 2014 IBH SYSTEMS GmbH and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v2.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v20.html
 *
 * Contributors:
 *     IBH SYSTEMS GmbH - initial API and implementation
 *******************************************************************************/
package org.eclipse.oneofour.asdu.types;

/*
 * Note that the order of this enum is important, since
 * the ordinal value is used in the protocol!
 */

/**
 * The double point type
 */
public enum DoublePoint
{
    INDETERMINATE_OR_INTERMEDIATE,
    OFF,
    ON,
    INDETERMINATE;
}