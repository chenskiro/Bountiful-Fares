package com.xueluoanping.bountifulfaresforge.api.data;

import net.minecraft.data.PackOutput;
import org.jetbrains.annotations.NotNull;

import java.nio.file.Path;

public class MutablePackOutput extends PackOutput {
    private PackOutput original;
    private Path outputFolder;

    public MutablePackOutput(PackOutput original) {
        super(original.getOutputFolder());
        this.original = original;
        this.outputFolder = original.getOutputFolder();
    }

    public MutablePackOutput set(Path newFolder) {
        this.outputFolder = newFolder;
        this.original = new PackOutput(outputFolder);
        return this;
    }

    public MutablePackOutput move(Path newFolder) {
        this.outputFolder = this.original.getOutputFolder().resolve(newFolder);
        return this;
    }

    public MutablePackOutput reset() {
        this.outputFolder = this.original.getOutputFolder();
        return this;
    }

    @Override
    public @NotNull Path getOutputFolder() {
        return outputFolder;
    }

}
