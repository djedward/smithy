/*
 * Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
 * SPDX-License-Identifier: Apache-2.0
 */

package software.amazon.smithy.rulesengine.language.evaluation.value;

import software.amazon.smithy.model.SourceLocation;
import software.amazon.smithy.model.node.Node;
import software.amazon.smithy.rulesengine.language.evaluation.type.Type;

public final class IntegerValue extends Value {
    private final int value;

    IntegerValue(int value) {
        super(SourceLocation.none());
        this.value = value;
    }

    @Override
    public Type getType() {
        return Type.integerType();
    }

    public int getValue() {
        return value;
    }

    @Override
    public IntegerValue expectIntegerValue() {
        return this;
    }

    @Override
    public Node toNode() {
        return Node.from(value);
    }
}
