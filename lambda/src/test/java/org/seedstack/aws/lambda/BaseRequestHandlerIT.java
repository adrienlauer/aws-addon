/**
 * Copyright (c) 2013-2016, The SeedStack authors <http://seedstack.org>
 *
 * This Source Code Form is subject to the terms of the Mozilla Public
 * License, v. 2.0. If a copy of the MPL was not distributed with this
 * file, You can obtain one at http://mozilla.org/MPL/2.0/.
 */
package org.seedstack.aws.lambda;

import org.junit.Test;
import org.seedstack.aws.lambda.fixtures.TestRequestHandler;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;

public class BaseRequestHandlerIT {
    @Test
    public void testHandlerInjection() throws Exception {
        TestRequestHandler testFunctionHandler = new TestRequestHandler();
        assertThat(testFunctionHandler.handleRequest("World", null)).isEqualTo("Hello World!");
    }
}
