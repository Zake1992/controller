/*
 * Copyright (c) 2014 Cisco Systems, Inc. and others.  All rights reserved.
 *
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License v1.0 which accompanies this distribution,
 * and is available at http://www.eclipse.org/legal/epl-v10.html
 */
package org.opendaylight.controller.md.sal.binding.impl;

import org.opendaylight.controller.md.sal.binding.api.ReadWriteTransaction;
import org.opendaylight.controller.md.sal.common.api.data.LogicalDatastoreType;
import org.opendaylight.controller.md.sal.dom.api.DOMDataReadWriteTransaction;
import org.opendaylight.yangtools.yang.binding.DataObject;
import org.opendaylight.yangtools.yang.binding.InstanceIdentifier;

import com.google.common.base.Optional;
import com.google.common.util.concurrent.ListenableFuture;

class BindingDataReadWriteTransactionImpl extends
        BindingDataWriteTransactionImpl<DOMDataReadWriteTransaction> implements ReadWriteTransaction {

    protected BindingDataReadWriteTransactionImpl(final DOMDataReadWriteTransaction delegate,
            final BindingToNormalizedNodeCodec codec) {
        super(delegate, codec);
    }

    @Override
    public <T extends DataObject> ListenableFuture<Optional<T>> read(final LogicalDatastoreType store,
            final InstanceIdentifier<T> path) {
        return doRead(getDelegate(), store, path);
    }
}