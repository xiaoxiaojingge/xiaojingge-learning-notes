return {
    'nvim-telescope/telescope.nvim',
    dependencies = { 'nvim-lua/plenary.nvim' },
    cmd = "Telescope",
    keys = {
        { "<leader>fr", "<CMD>Telescope oldfiles<CR>",   desc = "Recent" },
        { "<leader>ff", "<CMD>Telescope find_files<CR>", desc = "Files" },
        { "<leader>fw", "<CMD>Telescope live_grep<CR>",  desc = "Words" }
    },
    opts = {
        defaults = {
            prompt_prefix = " ",
            selection_caret = " ",
            mappings = {
                i = {
                    ["<C-d>"] = function(...)
                        return require("telescope.actions").preview_scrolling_down(...)
                    end,
                    ["<C-u>"] = function(...)
                        return require("telescope.actions").preview_scrolling_up(...)
                    end
                },
                n = {
                    ["q"] = function(...)
                        return require("telescope.actions").close(...)
                    end
                }
            },
            file_ignore_patterns = {
                "node_modules"
            }
        }
    }
}
