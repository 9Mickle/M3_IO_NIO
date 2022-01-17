package com.epam.task1.model.transport;

import java.io.Serializable;

/**
 * Конфигурация авто: кол-во колес, тип двигателя, тип руля.
 */
public class VehicleConfiguration implements Serializable {
    private transient Integer numberOfWheels;
    private String typeEngine;

    // C какой стороны находится руль.
    private String handDriveType;

    public VehicleConfiguration(Integer numberOfWheels, String typeEngine, String handDriveType) {
        this.numberOfWheels = numberOfWheels;
        this.typeEngine = typeEngine;
        this.handDriveType = handDriveType;
    }

    @Override
    public String toString() {
        return
                "numberOfWheels=" + numberOfWheels +
                ", typeEngine='" + typeEngine + '\'' +
                ", handDriveType='" + handDriveType + '\'';
    }

    public String getTypeEngine() {
        return typeEngine;
    }

    public String getHandDriveType() {
        return handDriveType;
    }
}
