/**
 * Copyright (c) 2013-2016, The SeedStack authors <http://seedstack.org>
 *
 * This Source Code Form is subject to the terms of the Mozilla Public
 * License, v. 2.0. If a copy of the MPL was not distributed with this
 * file, You can obtain one at http://mozilla.org/MPL/2.0/.
 */
package org.seedstack.aws.lambda;

import com.amazonaws.services.lambda.runtime.RequestHandler;
import com.google.inject.Injector;
import javax.inject.Inject;
import org.seedstack.seed.core.Seed;

public abstract class BaseRequestHandler<I, O> implements RequestHandler<I, O> {
    @Inject
    private static Injector injector;

    static {
        try {
            Seed.getLauncher().launch(new String[0]);
        } catch (Exception e) {
            throw Seed.translateException(e);
        }
    }

    public BaseRequestHandler() {
        injector.injectMembers(this);
    }
}
